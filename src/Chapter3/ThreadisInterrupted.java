package Chapter3;

import java.util.concurrent.TimeUnit;

public class ThreadisInterrupted {
    public static void main(String[] args) throws InterruptedException{
//        Thread thread = new Thread(){
//            @Override
//            public void run(){
//                while(true){
//                    //nothing to do
//                }
//            }
//        };
//
//        thread.setDaemon(true);
//        thread.start();
//        TimeUnit.MILLISECONDS.sleep(2);
//        System.out.printf("Thread is interrupted ? %s\n",thread.isInterrupted());
//        thread.interrupt();
//        System.out.printf("Thread is interrupt %s\n",thread.isInterrupted());
        Thread thread = new Thread(){
            @Override
            public void run(){
                while(true){
                    try{
                        TimeUnit.MINUTES.sleep(1);
                    }catch (InterruptedException e){
                        System.out.printf("I am be interrupted ? %s\n",isInterrupted());
                    }
                }
            }
        };
        thread.setDaemon(true);
        thread.start();
        TimeUnit.MILLISECONDS.sleep(2);
        System.out.printf("Thread is interrupted ? %s\n",thread.isInterrupted());
        thread.interrupt();
        //sleep是可中断方法，它会捕获中断信号，并擦除interrupt标识
        TimeUnit.MILLISECONDS.sleep(2);
        System.out.printf("Thread is interrupted ? %s\n",thread.isInterrupted());

    }
}
