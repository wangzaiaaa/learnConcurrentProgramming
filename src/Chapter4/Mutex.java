package Chapter4;

import java.util.concurrent.TimeUnit;
/*
每个对象都与一个monitor相关联，每一个线程在获得关联的monitor时会发生如下的几件事情
如果monitor的计数器为0，意味着monitor的Lock还没有被获得，某个线程获得之后将立即对该计数器加一
从此之后该线程就是这个monitor的所有者了。
如果monitor的所有者重入，会导致计数器再次累加
如果这个monitor已经被别的线程获取，会被阻塞直到monitor的计数器变为0
 */
public class Mutex {
    private final static Object MUTEX = new Object();
    public void accessResource(){
        synchronized (MUTEX){
            try{
                TimeUnit.MINUTES.sleep(10);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        final Mutex mutex = new Mutex();
        for(int i=0;i<5;i++){
            new Thread(mutex::accessResource).start();
        }
    }
}
