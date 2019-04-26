package Chapter3;

import java.util.concurrent.TimeUnit;

public class Threadinterrupted {
    public static void main(String[] args) {
        Thread.currentThread().interrupt();
        System.out.println("Main thread is interrupted ? " + Thread.interrupted());
        System.out.println("Main thread is interrupted ? " + Thread.currentThread().isInterrupted() );
        try{
            TimeUnit.MINUTES.sleep(1);
        }catch (InterruptedException e){
            System.out.println("I will be interrupted still");
        }
    }
    //    public static void main(String[] args) throws InterruptedException{
//        Thread  thread = new Thread(){
//            @Override
//            public void run(){
//                while(true){
//                    System.out.println(Thread.interrupted());
//                }
//            }
//        };
//        thread.setDaemon(true);
//        thread.start();
//        TimeUnit.MILLISECONDS.sleep(2);
//        thread.interrupt();
//    }

}
