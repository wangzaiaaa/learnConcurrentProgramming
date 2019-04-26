package Chapter3;

import java.util.concurrent.TimeUnit;

public class Volatile {
    static class MyTask extends Thread{
        private volatile  boolean closed = false;
        @Override
        public void run(){
            System.out.println("I will start work");
            while (!closed&&!isInterrupted()){
                System.out.println("I am working");
            }
            System.out.println("I will be exiting");
        }
        public void close(){
            this.closed = true;
            this.interrupt();
        }
    }
    public static void main(String [] args) throws InterruptedException{
        MyTask t = new MyTask();
        t.start();
        TimeUnit.SECONDS.sleep(1);
        System.out.println("System will be shutdown.");
        t.close();
    }

}
