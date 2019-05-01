package Chapter5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.locks.Condition;

import static java.lang.Thread.currentThread;


public class BooleanLock implements Lock {
    private Thread currentThread;
    private boolean locked = false;
    private final List<Thread> blockedList = new ArrayList<>();

    @Override
    public void lock() throws InterruptedException{
        synchronized (this){
            while (locked){
               final Thread tempThread = currentThread();
               try{
                   if(!blockedList.contains(tempThread))
                       blockedList.add(tempThread);
                   this.wait();
               }catch (InterruptedException e){
                   blockedList.remove(tempThread);
                   e.printStackTrace();
               }
            }
        }
        blockedList.remove(currentThread());
        this.locked = true;
        this.currentThread = currentThread();
    }

    @Override
    public void lock(long mills) throws InterruptedException, TimeoutException {
        synchronized (this){
            if(mills<=0){
                this.lock();
            }else{
                long remainingMills = mills;
                long endMills = System.currentTimeMillis() + remainingMills;
                while (locked){
                    if(remainingMills <= 0)throw new TimeoutException("can not het the lock during " + mills);
                    if(!blockedList.contains(currentThread()))
                        blockedList.add(currentThread());
                    this.wait(remainingMills);
                    remainingMills = endMills = System.currentTimeMillis();
                }
                blockedList.add(currentThread());
                this.locked = true;
                this.currentThread = currentThread();
            }

        }
    }

    @Override
    public void unlock() {
        synchronized (this){
            if(currentThread==currentThread()){
                this.locked = false;
                this.notifyAll();
            }
        }
    }

    @Override
    public List<Thread> getBlockedThreads() {
        return Collections.unmodifiableList(blockedList);
    }
}
