package javaconcepts.multithreading;

import java.util.concurrent.*;

public class CustomCallableExample {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        // Submit tasks using CustomCallable
        for (int i = 1; i <= 5; i++) {
            final int taskId = i;
            CustomCallable customCallable = new CustomCallable(taskId);
            Future<String> future = executorService.submit(customCallable);
            // You can use the Future object to get the result of the task
            System.out.println("future result after completion the task :"+future.get());
        }

        executorService.shutdown();
    }
}

class CustomCallable implements Callable<String> {
    private final int taskId;

    public CustomCallable(int taskId) {
        this.taskId = taskId;
    }

    @Override
    public String call() {
        try {
            System.out.println("Task " + taskId + " is executing by thread: " + Thread.currentThread().getName());
            Thread.sleep(1000); // Simulate task execution time
            System.out.println("Task " + taskId + " completed by thread: " + Thread.currentThread().getName());
            return "Task " + taskId + " result";
        } catch (InterruptedException e) {
            e.printStackTrace();
            return null;
        }
    }
}

