package javaconcepts.multithreading;

public class DeadlockExample {
    private static final Object resource1 = new Object();
    private static final Object resource2 = new Object();

    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> {
            synchronized (resource1) {
                System.out.println("Thread 1: Acquired lock on resource1");
                try {
                    Thread.sleep(100); // Intentional delay to induce deadlock
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (resource2) {
                    System.out.println("Thread 1: Acquired lock on resource2");
                }
            }
        });

        Thread thread2 = new Thread(() -> {
            synchronized (resource2) {
                System.out.println("Thread 2: Acquired lock on resource2");
                synchronized (resource1) {
                    System.out.println("Thread 2: Acquired lock on resource1");
                }
            }
        });

        thread1.start();
        thread2.start();
    }
}

/*
Deadlock in Java occurs when two or more threads are blocked forever, waiting for each other to release resources that they
need to proceed. This situation typically arises when multiple threads acquire locks on different resources and then attempt
to acquire locks on additional resources held by other threads, resulting in a cyclic waiting scenario.
In this example, thread1 acquires a lock on resource1 and then tries to acquire a lock on resource2, while thread2 acquires
a lock on resource2 and then tries to acquire a lock on resource1. Both threads will block indefinitely, resulting in a deadlock.
*/