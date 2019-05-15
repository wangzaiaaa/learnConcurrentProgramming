package Chapter12;

import java.util.concurrent.TimeUnit;

public class VolatileFoo {
    final static int MAX = 5;
    static volatile int init_value = 0;

    public static void main(String[] args) {
        new Thread(() -> {
            int localValue = init_value;
            while (localValue < MAX){
                if(localValue != init_value){
                    System.out.printf("The init_value is updated to [%d]\n",init_value);
                    localValue = init_value;
                }
            }
        },"Reader").start();

        new Thread(() -> {
            int loaclValue = init_value;
            while (loaclValue < MAX){
                System.out.printf("The init_value will be change to [%d]\n",++loaclValue);
                init_value = loaclValue;
            }
            try{
                TimeUnit.SECONDS.sleep(2);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        },"Updater").start();
    }

}
