import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ThreadPool {
  
    private BlockingQueue taskQueue = null;
    private List<ThreadPoolRunnable> runnable = new ArrayList<>();
    private boolean isStopped = false;

    public ThreadPool(int noOfThreads, int noOfTasks){
        taskQueue = new ArrayBlockingQueue(noOfTasks);

        for(int i=0; i<noOfThreads; i++){
            //PoolThreadRunnable poolThreadRunnable = new PoolThreadRunnable(taskQueue);
            runnable.add(new ThreadPoolRunnable(taskQueue));
        }
        for(ThreadPoolRunnable runnable : runnable){
            new Thread(runnable).start();
        }
    }

    public synchronized void  execute(Runnable task) throws Exception{
        if(this.isStopped) throw
                new IllegalStateException("ThreadPool is stopped");

        this.taskQueue.offer(task);
    }

    public synchronized void stop(){
        this.isStopped = true;
        for(ThreadPoolRunnable runnable : runnable){
            runnable.doStop();
        }
    }

    public synchronized void waitTillFinished() {
        while(this.taskQueue.size() > 0) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}