package Chapter4;

import java.util.concurrent.TimeUnit;
/*
根据jstack命令可以分析出synchronized修饰的实例方法是尝试获得本对象的锁
synchronized修饰的静态方法尝试获得类对象的锁
 */
public class ClassMonitor {
    private static synchronized void method1(){
        System.out.println(Thread.currentThread().getName() + " enter method1");
        try{
            TimeUnit.MINUTES.sleep(10);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
    private static synchronized void method2(){
        System.out.println(Thread.currentThread().getName() + " enter method2");
        try{
            TimeUnit.MINUTES.sleep(10);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Thread(ClassMonitor::method1).start();
        new Thread(ClassMonitor::method2).start();
    }
}
