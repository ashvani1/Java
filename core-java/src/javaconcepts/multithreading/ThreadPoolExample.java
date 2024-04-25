package javaconcepts.multithreading;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
public class ThreadPoolExample {
    public static void main(String[] args) {
        // Create a fixed-size thread pool with 3 threads
        ExecutorService executor = Executors.newFixedThreadPool(3);
        // Submit tasks to the thread pool
        for (int i = 0; i < 5; i++) {
            final int taskNumber = i;
            executor.submit(() -> {
                String threadName = Thread.currentThread().getName();
                System.out.println("Task " + taskNumber + " executed by thread: " + threadName);
                try {
                    Thread.sleep(2000); // Simulate task execution time
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
        // Shutdown the executor
        executor.shutdown();
    }
}



/*
* In this example:

We create a ThreadPoolExecutor using Executors.newFixedThreadPool(3), which creates a fixed-size thread pool with 3 threads.
We submit 5 tasks to the thread pool using executor.submit(Runnable task). Each task is a lambda expression that prints
a message indicating the task number and the thread executing it, simulates some task execution time, and then completes.

After submitting all tasks, we call executor.shutdown() to shut down the executor once all tasks have completed.
Now, let's understand the internal workings of the ThreadPoolExecutor:
Worker Threads: When tasks are submitted to the executor, it assigns them to worker threads from the thread pool. In our
example, since we have 5 tasks and a pool size of 3, some tasks will wait in the task queue until a worker thread becomes available.

Task Queue: Tasks waiting to be executed are stored in a task queue. In our example, tasks that cannot be immediately
executed due to the limited number of threads in the pool are queued until a thread becomes available.
Thread Management: The ThreadPoolExecutor dynamically manages the number of active threads based on the workload. It
creates new threads up to the core pool size (3 in our example) if there are pending tasks in the queue. If the workload
increases beyond the core pool size, additional threads may be created up to the maximum pool size. Once the workload decreases,
excess threads may be terminated to conserve resources.

Thread States: Each worker thread in the thread pool can be in different states, such as running, waiting, or terminated.
The ThreadPoolExecutor keeps track of the state of each thread and manages their lifecycle accordingly.

Overall, the ThreadPoolExecutor efficiently manages the execution of tasks by optimizing the utilization of available
resources and adjusting the number of active threads dynamically based on the workload, ensuring smooth execution of concurrent
tasks.*/
