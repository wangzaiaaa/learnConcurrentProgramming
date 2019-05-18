package Chapter15;

public interface Observable {
    enum Cycle{
        STARTED,RUNNING,DONE,ERROR
    }

    Cycle getCycle();

    void start();

    void interrupt();
}
