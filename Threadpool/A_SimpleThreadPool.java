package Threadpool;

 import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class A_SimpleThreadPool {

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(2);
        for (int i = 0; i < 5; i++) {
           
            executor.execute(new A_WorkerThread(" " + i));
          }
        executor.shutdown();
        while (!executor.isTerminated()) {
        }
        System.out.println("Finished all threads");
    }

}
