package javaconcepts.multithreading;

public class WaitingExample {
    public static void main(String[] args) throws InterruptedException {
        Object lock = new Object();

        Thread waitingThread = new Thread(() -> {
            synchronized (lock) {
                try {
                    System.out.println("WaitingThread: Waiting for notification...");
                    lock.wait(); // Thread enters the waiting state
                    System.out.println("WaitingThread: Resumed after notification.");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread notifyingThread = new Thread(() -> {
            try {
                Thread.sleep(2000); // Simulate some processing time
                synchronized (lock) {
                    System.out.println("NotifyingThread: Sending notification...");
                    lock.notify(); // Notify the waiting thread
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        waitingThread.start();
        notifyingThread.start();

        //below code will be holding main thread to complete before waitingThread and notifyingThread
        waitingThread.join();
        notifyingThread.join();
    }
}

