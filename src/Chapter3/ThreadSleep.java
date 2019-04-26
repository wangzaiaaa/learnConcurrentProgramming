package Chapter3;

public class ThreadSleep {
    /**
     *
     * 可以用TimeUnit来代替TimeUnit 比如线程想要休眠3小时24分17秒88毫秒
     * 1 Thread.sleep(12257088L);
     * 2 TimeUnit.HOURS.sleep(3);
     * TimeUnit.MINUTES.sleep(24);
     * TimeUnit.SECONDS.sleep(17);
     * TimeUnit.MILLISECONDS.sleep(88);
     */
    public static void main(String[] args) {
        new Thread(
                () ->
                {
                    long startTime = System.currentTimeMillis();
                    sleep(2_000L);
                    long endTime = System.currentTimeMillis();
                    System.out.println(String.format("Total spend %d ms",(endTime-startTime)));
                }
        ).start();
        long startTime = System.currentTimeMillis();
        sleep(3_000L);
        long endTime = System.currentTimeMillis();
        System.out.println(String.format("Main thread total spend %d ms",(endTime-startTime)));
    }
    private static void sleep(long ms){
        try{
            Thread.sleep(ms);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
