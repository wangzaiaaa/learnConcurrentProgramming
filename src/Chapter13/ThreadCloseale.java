package Chapter13;

public class ThreadCloseale extends Thread{
    private volatile boolean started = true;
    @Override
    public void run(){
        while (started){

        }
    }
    public void shutdown(){
        this.started = false;
    }
}
