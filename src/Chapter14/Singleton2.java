package Chapter14;

import java.net.Socket;
import java.sql.*;

/**
 * @author bonsoirzw
 * @date 2019/5/16
 */
public class Singleton2 {
    private byte[] data = new byte[1024];
    private static Singleton2 instance = null;
    Connection conn = null;
    Socket socket;
    private Singleton2(){
        //conn初始化
        //socket初始化
    }

    /**
     * 当一个线程完成instance的初始化，conn和socket没有完成初始化时，另一个线程使用conn和socket时
     * 会引发空指针异常
     * @return
     */
    public static Singleton2 getInstance(){
        if(instance == null){
            synchronized (Singleton2.class){
                if(instance == null){
                    instance = new Singleton2();
                }
            }
        }
        return instance;
    }



}
