package javaconcepts.multithreading.JMMconcepts;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class AtomicityExampleUsingExecutor {
        private static AtomicInteger count = new AtomicInteger(0);

        public static void main(String[] args) throws InterruptedException {
            // Create an ExecutorService with two threads
            ExecutorService executor = Executors.newFixedThreadPool(2);

            // Submit tasks to increment and decrement count
            executor.submit(AtomicityExample::incrementCount);
            executor.submit(AtomicityExample::decrementCount);

            // Shutdown the executor to prevent new tasks from being submitted
            executor.shutdown();

            // Wait for all tasks to complete
            while (!executor.isTerminated()) {
                // Optional: You can print some message while waiting
                System.out.println("Waiting for tasks to complete...");
                Thread.sleep(100); // Sleep for a short time before checking again
            }

            // Main thread: Read count
            System.out.println("Count: " + getCount()); // Output will be consistent due to atomicity
        }

        private static void incrementCount() {
            // Simulate some processing time
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            count.incrementAndGet();
        }

        private static void decrementCount() {
            // Simulate some processing time
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            count.decrementAndGet();
        }

        private static int getCount() {
            return count.get();
        }
    }
