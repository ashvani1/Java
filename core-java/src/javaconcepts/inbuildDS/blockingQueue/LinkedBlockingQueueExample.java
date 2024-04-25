package javaconcepts.inbuildDS.blockingQueue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class LinkedBlockingQueueExample {
    public static void main(String[] args) {
        BlockingQueue<String> queue = new LinkedBlockingQueue<>();

        // Producer thread
        Thread producer = new Thread(() -> {
            try {
                // Produce messages
                for (int i = 1; i <= 5; i++) {
                    String message = "Message " + i;
                    queue.put(message);
                    System.out.println("Produced: " + message);
                    Thread.sleep(1000); // Simulate message production delay
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        // Consumer threads
        Thread consumer1 = new Thread(() -> {
            try {
                while (true) {
                    String message = queue.take();
                    System.out.println("Consumer 1 Received: " + message);
                    Thread.sleep(1500); // Simulate processing delay
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread consumer2 = new Thread(() -> {
            try {
                while (true) {
                    String message = queue.take();
                    System.out.println("Consumer 2 Received: " + message);
                    Thread.sleep(2000); // Simulate processing delay
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        // Start producer and consumer threads
        producer.start();
        consumer1.start();
        consumer2.start();
    }
}
