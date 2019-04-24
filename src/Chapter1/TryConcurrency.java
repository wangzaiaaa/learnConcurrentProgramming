package Chapter1;

import java.util.concurrent.TimeUnit;

public class TryConcurrency {
    public static void main(String[] args) {
        new Thread(){
            @Override
            public void run(){
                enjoyMusic();
            }
        }.start();
        new Thread(TryConcurrency::browseNews).start();
//        enjoyMusic();
    }

    private static void browseNews(){
        for(;;){
            System.out.println("Uh-huh, the good news");
            sleep(1);
        }
    }
    private static void enjoyMusic(){
        for(;;){
            System.out.println("Uh-huh,thw nice music.");
            sleep(1);
        }
    }
    private static void sleep(int seconds){
        try{
            TimeUnit.SECONDS.sleep(seconds);

        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
