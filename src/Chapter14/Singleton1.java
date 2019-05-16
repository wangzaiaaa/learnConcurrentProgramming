package Chapter14;

/**
 * @author bonsoirzw
 * @date 2019/5/16
 */

/**
 * 懒汉模式：在使用类实例的时候再去创建（用时创建），这样可以避免
 * 类在初始化时提前创建。
 * final不允许继承
 */
public final class Singleton1 {
    private byte [] data = new byte[1024];
    private static Singleton1 instance = null;
    private Singleton1(){

    }

    /**
     * 在多线程的环境下不能保证实例是唯一的
     * @return
     */
    public static Singleton1 getInstance(){
        if(instance == null){
            instance = new Singleton1();
        }
        return instance;
    }

    /**
     * 加入同步控制，每次只有一个线程能进入，但是synchronized效率不够高
     * @return
     */
    public synchronized static Singleton1 getInstance1(){
        if(instance == null){
            instance = new Singleton1();
        }
        return instance;
    }



}
