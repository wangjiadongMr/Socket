package server;

import serverthread.ServerThread;
import util.AbstractLoggerInfo;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author wang
 * @data on 2018/3/23
 */
public class Server extends AbstractLoggerInfo implements  Runnable{

    private ServerSocket serverSocket;
    private Socket socket;
    private boolean isConnection;
    private String message;


    public Server() {

        try {
            serverSocket = new ServerSocket(8889);
        } catch (IOException e) {
            e.printStackTrace();
            logger.info("初始化出错");
        }
    }

    public void start() {

        while (true) {
            try {
                System.out.println("等待一个客户连接········");
                socket = serverSocket.accept();
                System.out.println("········连接成功");
                isConnection = true;
                getMessage();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (socket != null) {
                    try {
                        socket.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                        System.out.println("关闭流异常........");
                    }
                }
            }
        }
    }

    public synchronized void getMessage() {

        while (isConnection) {
            InputStream inputStream = null;
            BufferedInputStream bf = null;
            try {
                inputStream = socket.getInputStream();
                bf = new BufferedInputStream(inputStream);
                InputStreamReader inputStreamReader = new InputStreamReader(bf);
                BufferedReader bfreader = new BufferedReader(inputStreamReader);
                message = bfreader.readLine();
                System.out.println(message);
            } catch (Exception e) {
                e.printStackTrace();
            }finally {

                try {

                    if(socket == null){

                        inputStream.close();
                        bf.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                    logger.info("流关闭异常");
                }
            }
        }
    }

    public static void main(String[] args) {
        Server server = new Server();
        Thread thread = new Thread(server);
        thread.start();
        server.start();
    }

    public void run() {
        ServerThread serverThread = new ServerThread(socket, isConnection);
        Thread thread = new Thread(serverThread);
        thread.start();
    }

}
