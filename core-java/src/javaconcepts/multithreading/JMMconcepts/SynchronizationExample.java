package javaconcepts.multithreading.JMMconcepts;

public class SynchronizationExample {
    private static int count = 0;

    public static synchronized void increment() {
        count++;
    }

    void correctWayOfSynchronization() {

        // Thread 1: Increment count
        Thread thread1 = new Thread(() -> {
            increment();
        });
        thread1.start();

        // Thread 2: Increment count
        Thread thread2 = new Thread(() -> {
            increment();
        });
        thread2.start();

        // Main thread: Wait for threads to complete
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Main thread: Read count
        System.out.println("correct way Count: " + count); // Output will be consistent due to synchronization
    }


    public static void increment1() {
        count++;
    }

    void incorrectWayOfSynchronization() {
        Thread thread1 = new Thread(() -> {
            increment1();
        });
        thread1.start();

        // Thread 2: Increment count
        Thread thread2 = new Thread(() -> {
            increment1();
        });
        thread2.start();

        // Main thread: Wait for threads to complete
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Main thread: Read count
        System.out.println("incorrect way Count: " + count); // Output may vary due to lack of synchronization
    }
    public static void main(String[] args) {
        new SynchronizationExample().correctWayOfSynchronization();
        new SynchronizationExample().incorrectWayOfSynchronization();
    }
}

