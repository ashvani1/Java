package javaconcepts.multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CustomRunnableExample {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        // Submit tasks using CustomRunnable
        for (int i = 1; i <= 5; i++) {
            final int taskId = i;
            CustomRunnable customRunnable = new CustomRunnable(taskId);
            executorService.submit(customRunnable);
        }

        executorService.shutdown();
    }
}

class CustomRunnable implements Runnable {
    private final int taskId;

    public CustomRunnable(int taskId) {
        this.taskId = taskId;
    }

    @Override
    public void run() {
        try {
            System.out.println("Task " + taskId + " is executing by thread: " + Thread.currentThread().getName());
            Thread.sleep(1000); // Simulate task execution time
            System.out.println("Task " + taskId + " completed by thread: " + Thread.currentThread().getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

