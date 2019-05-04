package Chapter8;

public interface RunnableQueue {

    void offer(Runnable runnable);

    Runnable take();

    int size();
}
