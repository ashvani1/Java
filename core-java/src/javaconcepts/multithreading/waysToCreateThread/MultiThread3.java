package javaconcepts.multithreading.waysToCreateThread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MultiThread3 {
    public static void main(String[] args) {
        System.out.println(Runtime.getRuntime().availableProcessors());
        ExecutorService es = Executors.newScheduledThreadPool(10);
        //ExecutorService es = Executors.newCachedThreadPool();
        //ExecutorService es = Executors.newSingleThreadExecutor();
        //ExecutorService es = Executors.newFixedThreadPool(8);

        for(int i = 0; i < 10000; i++) {
            int taskNo = i;
            es.submit(
                    () -> System.out.println("doing some magic for i = " + taskNo + " and current thread "+ Thread.currentThread().getName())
            );
        }
        es.shutdown();
    }
}
