package javaconcepts.inbuildDS.concurrentCollections;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ConcurrentLinkedQueueExample {

    public static void main(String[] args) {
        ConcurrentLinkedQueue<Integer> queue = new ConcurrentLinkedQueue<>();
        ExecutorService executor = Executors.newFixedThreadPool(2);

        executor.submit(() -> {
            for (int i = 0; i < 1000; i++) {
                queue.offer(i);
            }
        });

        executor.submit(() -> {
            for (int i = 0; i < 500; i++) {
                queue.offer(i*10000);
            }
        });

        executor.shutdown();
        //will work as join() and prevent main threads until above task completed
        while (!executor.isTerminated()) { }

        for(Integer current : queue) {
            System.out.println(current);
        }
        System.out.println("Queue size: " + queue.size());

    }
}

