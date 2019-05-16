package Chapter14;

/**
 * @author bonsoirzw
 * @date 2019/5/16
 *
 */

/**
 * 饿汉模式
 */
public class Singleton {
    private byte [] data = new byte[1024];
    private static Singleton instance = new Singleton();
    private Singleton(){

    }
    public static Singleton getInstance(){
        return instance;
    }

}
