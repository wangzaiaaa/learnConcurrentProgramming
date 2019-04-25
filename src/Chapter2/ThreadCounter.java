package Chapter2;

import java.sql.SQLOutput;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 进程内存的大小为：堆内存 + 线程数量 * 栈内存
 * -Xms 初始堆大小
 * -Xmx 最大堆大小
 * -Xss 每个线程的栈大小
 * 堆内存越大 线程的最大数目越小
 * 每个线程的栈内存越大 线程的最大数目越小
 */
public class ThreadCounter extends Thread {
    final static AtomicInteger counter = new AtomicInteger(0);

    public static void main(String[] args) {
        try{
            while (true){
                new ThreadCounter().start();
            }
        }catch (Throwable e){
            System.out.println("failed At=>" + counter.get());
        }
    }
    @Override
    public void run(){
        try{
            System.out.println("The "+counter.getAndIncrement() + " thread be created.");
            TimeUnit.MINUTES.sleep(10);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
