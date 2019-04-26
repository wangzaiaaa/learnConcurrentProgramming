package Chapter3;

import java.util.concurrent.TimeUnit;

public class InterruptThreadExit {
    public static void main(String[] args) throws InterruptedException{
        Thread t = new Thread(){
            @Override
//            public void run(){
//                System.out.println("I will start work");
//                while (!isInterrupted()){
//                    System.out.println("I am working");
//                }
//                System.out.println("I will be exiting");
//            }
            public void run(){
                System.out.println("I will start work");
                for(;;){
                    try{
                        TimeUnit.MILLISECONDS.sleep(1);
                        System.out.println("I am working");
                    }catch (InterruptedException e){
                        break;
                    }
                }
            }
        };
        t.start();
        TimeUnit.SECONDS.sleep(1);
        System.out.println("System will be shutdown");
        t.interrupt();
    }
}
