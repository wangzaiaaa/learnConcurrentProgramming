package Chapter2;


//在创建线程的时候如果没有指定ThreadGroup的话，子线程将会加入到父线程所在的线程组
public class ThreadConstruction {
    public static void main(String[] args) {
        Thread t1 = new Thread("t1");
        ThreadGroup group = new ThreadGroup("TestGroup");
        Thread t2 = new Thread(group,"t2");
        ThreadGroup mainThreadGroup = Thread.currentThread().getThreadGroup();
        System.out.println("Main thread belong group:"+ mainThreadGroup.getName());
        System.out.println("t1 and main belong the same group:" + (mainThreadGroup==t1.getThreadGroup()));
        System.out.println("t2 thread group not belong main group:" + (mainThreadGroup==t2.getThreadGroup()));


    }
}
