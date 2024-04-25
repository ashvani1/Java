package javaconcepts.multithreading.JMMconcepts;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SynchronizationExampleUsingExecutor {
    private static int count = 0;

    // Correct way of synchronization
    public static synchronized void increment() {
        count++;
    }

    // Incorrect way of synchronization
    public static void increment1() {
        count++;
    }

    void correctWayOfSynchronization() {
        ExecutorService executor = Executors.newFixedThreadPool(2);

        // Submit tasks to the executor
        for (int i = 0; i < 2; i++) {
            executor.submit(() -> {
                increment();
            });
        }

        // Shut down the executor after tasks are complete
        executor.shutdown();

        // Main thread: Wait for threads to complete
        while (!executor.isTerminated()) {
            Thread.yield();
        }

        // Main thread: Read count
        System.out.println("Correct way Count: " + count); // Output will be consistent due to synchronization
    }

    void incorrectWayOfSynchronization() {
        ExecutorService executor = Executors.newFixedThreadPool(2);

        // Submit tasks to the executor
        for (int i = 0; i < 2; i++) {
            executor.submit(() -> {
                increment1();
            });
        }

        // Shut down the executor after tasks are complete
        executor.shutdown();

        // Main thread: Wait for threads to complete
        while (!executor.isTerminated()) {
            Thread.yield();
        }

        // Main thread: Read count
        System.out.println("Incorrect way Count: " + count); // Output may vary due to lack of synchronization
    }

    public static void main(String[] args) {
        new SynchronizationExample().correctWayOfSynchronization();
        new SynchronizationExample().incorrectWayOfSynchronization();
    }
}

