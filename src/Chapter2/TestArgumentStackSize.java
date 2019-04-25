package Chapter2;

//在Thread的构造函数中，可以发现有一个特殊的参数stackSize，stackSize越大代表
//这个线程的的递归深度越深，当然这个参数受到平台和硬件的影响
public class TestArgumentStackSize {
    public static void main(String[] args) {
        if(args.length<1){
            System.out.println("Please enter the stack size.");
            System.exit(1);
        }
        ThreadGroup group = new ThreadGroup("testGroup");
        Runnable runnable = new Runnable() {
            final int MAX = Integer.MAX_VALUE;
            @Override
            public void run() {
                int i=0;
                recurse(i);
            }
            private void recurse(int i){
                System.out.println(i);
                if(i<MAX){
                    recurse(i+1);
                }
            }
        };
        Thread thread = new Thread(group,runnable,"Test",Integer.parseInt(args[0]));
        thread.start();
    }
}
