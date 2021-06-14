import java.util.*;

public class ThreadPoolMain {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int noOfThreads;
        int noofTasks;
        System.out.println("Enter number of threads to be used:");
        noOfThreads=sc.nextInt();
        System.out.println("Enter number of tasks to be executed:");
        noofTasks=sc.nextInt();
        ThreadPool threadPool = new ThreadPool(noOfThreads, noofTasks);

        for(int i=0; i<noofTasks; i++) {

            int taskNo = i;
            threadPool.execute( () -> {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                String message =
                        Thread.currentThread().getName()
                                + ": Task " + taskNo ;
                System.out.println(message);
            });
        }

        threadPool.waitTillFinished();
        threadPool.stop();
        sc.close();
    }
}