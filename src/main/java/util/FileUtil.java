package util;

import java.io.File;
/**
 * @author wang
 * @data on 2018/4/2
 */
public class FileUtil {

    public static void main(String[] args) {

        String strDir = "/Users/wang/Documents/dong";
        File  file = new File(strDir);
        if(file.exists()){
            return;
        }else {
           file.mkdir();
        }
    }
}
