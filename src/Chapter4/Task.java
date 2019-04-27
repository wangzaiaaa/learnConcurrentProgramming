package Chapter4;

public class Task implements Runnable{
    private final Object MUTEX = new Object();
    @Override
    public void run(){
        synchronized (MUTEX){
            //do something
        }
    }
    //这种情况看不到互斥的效果，因为争夺的不是同一个monitor
    public static void main(String[] args) {
        for(int i=0;i<5;i++){
            new Thread(Task::new).start();
        }
    }
}
