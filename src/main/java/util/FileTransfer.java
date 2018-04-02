package util;

import java.io.*;

/**
 * @author wang
 * @data on 2018/4/2
 */
public class FileTransfer {

    public static void main(String[] args) {
        String strDir = "/User/wang/Documents/dong";
        File file = new File(strDir);

        try {
            byte[] by = new byte[1024];
            InputStream inputStream = new FileInputStream(file);
            int readCount = 0;
            OutputStream outputStream = new FileOutputStream("");
            readCount = inputStream.read(by,0,1024);
            if(readCount != -1){

               outputStream.write(by,0,1024);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
