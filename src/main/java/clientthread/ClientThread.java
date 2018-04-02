package clientthread;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * @author wang
 * @data on 2018/3/29
 */
public class ClientThread implements Runnable {

    private Socket socket;
    private boolean isFlag;

    public void run() {

        getMessage();
    }

    public ClientThread(Socket socket ,boolean isFlag) {

        this.socket = socket;
        this.isFlag = isFlag;
    }

    public void getMessage(){

        while (isFlag) {

            try {
                InputStream inputStream = socket.getInputStream();
                InputStreamReader reader = new InputStreamReader(inputStream, "utf-8");
                BufferedReader bfReader = new BufferedReader(reader);
                String message = "";

                if((message = bfReader.readLine() )!= null){
                    System.out.println(message);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
