package javaconcepts.multithreading;

public class DeadlockResolutionExample {
    private static final Object resource1 = new Object();
    private static final Object resource2 = new Object();

    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> {
            synchronized (resource1) {
                System.out.println("Thread 1: Acquired lock on resource1");
                try {
                    Thread.sleep(100); // Intentional delay to avoid simultaneous acquisition
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (resource2) {
                    System.out.println("Thread 1: Acquired lock on resource2");
                }
            }
        });

        Thread thread2 = new Thread(() -> {
            synchronized (resource1) {
                System.out.println("Thread 2: Acquired lock on resource1");
                synchronized (resource2) {
                    System.out.println("Thread 2: Acquired lock on resource2");
                }
            }
        });

        thread1.start();
        thread2.start();
    }
}

/*

To resolve the deadlock in the given program, we need to ensure that both threads acquire locks in the same order.
This prevents the possibility of cyclic dependencies and eliminates the deadlock scenario. */