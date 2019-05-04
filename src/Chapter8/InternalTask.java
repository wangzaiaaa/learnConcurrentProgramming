package Chapter8;

public class InternalTask implements Runnable{
    private final RunnableQueue runnableQueue;
    private volatile boolean running = true;
    public InternalTask(RunnableQueue runnableQueue){
        this.runnableQueue = runnableQueue;
    }
    @Override
    public void run(){
        while (running && !Thread.currentThread().isInterrupted()){
            Runnable task = runnableQueue.take();
            task.run();
        }
    }
    public void stop(){
        this.running = false;
    }
}
