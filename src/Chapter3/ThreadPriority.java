package Chapter3;

public class ThreadPriority {
    //线程的优先级大小大于0小于10 同时线程的优先级也不能大于其所属组的最大优先级
    public static void main(String[] args) {
//        ThreadGroup group = new ThreadGroup("demo");
//        group.setMaxPriority(7);
//        Thread t1 = new Thread(group,"t1");
//        t1.setPriority(10);
//        System.out.println(t1.getPriority());// 7
        Thread t1 = new Thread();
        System.out.println("t1 priority is " + t1.getPriority());
        Thread t2 = new Thread(()->
        {
            Thread t3 = new Thread();
            System.out.println("t3 priority is " + t3.getPriority());
        });
        t2.setPriority(6);
        t2.start();
        System.out.println("t2 priority is " + t2.getPriority());

    }




    //    public static void main(String[] args) {
//        Thread t1 = new Thread(() ->
//        {
//            while (true){
//                System.out.println("t1");
//            }
//        });
//        t1.setPriority(3);
//        Thread t2 = new Thread(()->
//        {
//            while(true){
//                System.out.println("t2");
//            }
//        });
//        t2.setPriority(4);
//        t1.start();
//        t2.start();
//
//    }

}
