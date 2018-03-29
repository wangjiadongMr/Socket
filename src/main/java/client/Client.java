package client;

import util.AbstractLoggerInfo;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

/**
 * @author wang
 * @data on 2018/3/23
 */
public class Client extends AbstractLoggerInfo {
    
    private Socket socket;
    private boolean isFlag;

    public Client() {

        try {
            socket = new Socket("localhost", 8889);
            System.out.println("连接成功");
            isFlag = true;
        } catch (IOException e) {
            e.printStackTrace();
            isFlag = false;
        }
    }

    public void start() {

        while (isFlag) {

            try {

                OutputStream outputStream = socket.getOutputStream();
                OutputStreamWriter outWriter = new OutputStreamWriter(outputStream, "utf-8");
                PrintWriter printWriter = new PrintWriter(outWriter,true);

                System.out.println("请输入用户名");
                Scanner scanner = new Scanner(System.in);
                String nickName = scanner.nextLine();
                if (nickName == null) {
                    break;
                }
                printWriter.println(nickName);
                System.out.println("请输入文件目录");
                String filePath = scanner.nextLine();
                File file = new File(filePath);
                InputStreamReader inReader = new InputStreamReader(new FileInputStream(file), "utf-8");
                BufferedReader bf = new BufferedReader(inReader);
                String message = "";
                while ((message = bf.readLine()) != null) {
                    printWriter.print(message);
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        Client client = new Client();
        client.start();
    }
}
