import java.util.concurrent.BlockingQueue;

public class ThreadPoolRunnable implements Runnable {

    private Thread thread = null;
    private BlockingQueue<?> taskQueue = null;
    private boolean isStopped = false;

    public ThreadPoolRunnable(BlockingQueue<?> queue){
        taskQueue = queue;
    }
    @Override
    public void run(){
        this.thread = Thread.currentThread();
        while(!isStopped()){
            try{
                Runnable runnable = (Runnable) taskQueue.take();
                runnable.run();
            } catch(Exception e){
                e.printStackTrace();
            }
        }
    }

    public synchronized void doStop(){
        isStopped = true;
        this.thread.interrupt();
    }

    public synchronized boolean isStopped(){
        return isStopped;
    }
}
