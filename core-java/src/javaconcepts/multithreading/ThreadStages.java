package javaconcepts.multithreading;

public class ThreadStages {

    public static void main(String[] args) {
        // Create and start a new thread
        Thread thread = new Thread(() -> {
            // Runnable state: Thread starts executing its task
            System.out.println("Thread: Doing some processing...");
            try {
                Thread.sleep(3000); // Simulate I/O or processing time
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Thread: Finished processing.");
            // Terminated state: Thread completes its task and terminates
        });
        thread.start(); // Running state: Thread is executing its task

        // Simulate main thread doing some work
        System.out.println("Main: Starting main thread work...");
        try {
            Thread.sleep(1000); // Simulate some work in the main thread
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Main: Main thread work completed.");

        // Blocked/Waiting state: Main thread waiting for 'thread' to finish
        try {
            thread.join(); // Wait for the thread to finish
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Running state: Main thread continues execution after waiting for 'thread' to finish

        // Print a message after the thread has finished
        System.out.println("Main: Thread has finished processing.");
    }
}

/*
In Java, the lifecycle of a thread goes through several stages. Let's explain each stage with a simple example:

New: The thread is in this state when it's created but not yet started.
Runnable: The thread is ready to run, but the scheduler has not selected it to be the running thread.
Running: The thread is currently being executed.
Blocked: The thread is waiting for a monitor lock to enter a synchronized block or method, or waiting for I/O operations
to complete.
when a thread wants to enter a synchronized block or method, it needs to acquire a lock on the object associated with
that block or method. If another thread already holds the lock, the thread trying to enter the synchronized block or
method will wait until the lock becomes available. Once it acquires the lock, it can proceed with executing the
synchronized code.
Waiting: The thread is waiting indefinitely for another thread to perform a particular action. It can transition to the
runnable state upon notification from another thread.
Timed Waiting: The thread is waiting for a specified amount of time. It can transition to the runnable state when the
 specified time elapses or upon notification from another thread.
Terminated: The thread has completed execution or terminated due to an uncaught exception.

*/