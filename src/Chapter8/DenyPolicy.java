package Chapter8;

public interface DenyPolicy {
    void reject(Runnable runnable,ThreadPool threadPool);
    //直接丢弃任务
    class DiscardDenyPolicy implements DenyPolicy{
        @Override
        public void reject(Runnable runnable,ThreadPool threadPool){
            //nothing to do
        }
    }
    class AbortDenyPolicy implements DenyPolicy{
        @Override
        public void reject(Runnable runnable,ThreadPool threadPool){
            throw new RunnableDenyException("The runnable " + runnable + " will be abort.");
        }
    }
    //使任务在提交的线程中执行
    class RunnerDenypolicy implements DenyPolicy{
        @Override
        public void reject(Runnable runnable,ThreadPool threadPool){
            if(!threadPool.isShutdown()){
                runnable.run();
            }
        }
    }
}
