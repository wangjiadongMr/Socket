package util;

/**
 * @author wang
 * @data on 2018/3/29
 */
public class ThreadDemo extends Thread{

    @Override
    public void run() {
        for (int i = 0; i < 100 ; i++) {
            System.out.println("hahah");
        }
    }

    public static void main(String[] args) {
        ThreadDemo threadDemo = new ThreadDemo();
        Thread thread = new Thread(threadDemo);
        thread.start();
    }
}
