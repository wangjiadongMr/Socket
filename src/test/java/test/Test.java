package test;

import java.io.*;
import java.nio.channels.FileChannel;

/**
 * @author wang
 * @data on 2018/3/25
 */

public class Test {

    @org.junit.Test
    public void test() {

        String readDir = "/Users/wang/Downloads/soft_file_dmg/ideaIU-2017.3.2.dmg";
        String writeDir = "/Users/wang/Documents/ddd.mmg";

        byte by[] = new byte[1024];
        try {
            InputStream inputStream = new FileInputStream(readDir);
            FileOutputStream fileOutputStream = new FileOutputStream(writeDir);
            int c = inputStream.read(by,0,1024);
            if( c != -1){
                fileOutputStream.write(by,0,1024);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @org.junit.Test
    public void test2(){

        String path = "/Users/wang/Downloads/soft_file_dmg/ideaIU-2017.3.2.dmg";
        File filePath = new File(path);
        try {
            long startTime = System.currentTimeMillis();
            FileChannel fileChannel = new FileInputStream(filePath).getChannel();
            FileChannel targetFile = new FileOutputStream(new File("/Users/wang/Downloads/wang.dmg")).getChannel();
            try {

                targetFile.transferFrom(fileChannel, 0, fileChannel.size());

            } catch (IOException e) {
                e.printStackTrace();
            }
            long endTime = System.currentTimeMillis();
            System.out.println("耗时为："+(endTime-startTime));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }



    @org.junit.Test
    public void test3(){
    }




}
