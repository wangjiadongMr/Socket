package serverthread;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 * @author wang
 * @data on 2018/3/28
 */
public class ServerThread implements Runnable {

  private boolean isConnection;
  private Socket socket;
  private String message;

  public void run() {

    sendMessage();

  }

  public ServerThread(Socket socket, boolean isConnection) {
    this.socket = socket;
    this.isConnection = isConnection;
  }

  public synchronized void sendMessage() {

    OutputStream outputStream;
    OutputStreamWriter writer;

    while (isConnection) {
      try {
        outputStream = socket.getOutputStream();
        writer = new OutputStreamWriter(outputStream, "utf-8");
        PrintWriter printWriter = new PrintWriter(writer, true);
        System.out.println("请输入要传送的信息");
        Scanner scanner = new Scanner(System.in);
        message = scanner.nextLine();
        printWriter.println(message);
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
  }
}
