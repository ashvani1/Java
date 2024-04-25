package javaconcepts.multithreading.JMMconcepts;import java.util.concurrent.atomic.AtomicInteger;

public class AtomicityExample {
    private static AtomicInteger count = new AtomicInteger(0);

    public static void main(String[] args) throws InterruptedException {
        // Thread 1: Increment count
        Thread thread1 = new Thread(() -> {
            incrementCount();
        });
        thread1.start();

        // Thread 2: Decrement count
        Thread thread2 = new Thread(() -> {
            decrementCount();
        });
        thread2.start();

        thread1.join();
        thread2.join();

        // Main thread: Read count
        System.out.println("Count: " + getCount()); // Output will be consistent due to atomicity
    }

    static void incrementCount() {
        // Simulate some processing time
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        count.incrementAndGet();
    }

    static void decrementCount() {
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

/*

The AtomicInteger class from java.util.concurrent.atomic package provides atomic operations for int values without the
need for explicit synchronization

When you call incrementAndGet() or decrementAndGet() on an AtomicInteger, these operations are performed atomically without
the need for explicit synchronization. As a result, multiple threads can safely call these methods concurrently without the
risk of data corruption or race conditions. This allows you to achieve thread safety and atomicity without using synchronized
blocks or methods.

*/