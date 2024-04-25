package javaconcepts.inbuildDS.blockingQueue;

import java.util.concurrent.PriorityBlockingQueue;

public class PriorityBlockingQueueExample {
    public static void main(String[] args) {
        PriorityBlockingQueue<Integer> queue = new PriorityBlockingQueue<>();

        // Producer thread
        Thread producer = new Thread(() -> {
            try {
                for (int i = 10; i >= 1; i--) {
                    queue.put(i); // Add elements to the queue
                    System.out.println("Produced: " + i);
                    Thread.sleep(1000);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        // Consumer thread
        Thread consumer = new Thread(() -> {
            try {
                for (int i = 0; i < 10; i++) {
                    int value = queue.take(); // Retrieve elements from the queue
                    System.out.println("Consumed: " + value);
                    Thread.sleep(2000);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        producer.start();
        consumer.start();
    }
}



/*
In this example:

We create a PriorityBlockingQueue to store integers.
We start two threads: one for producing elements and another for consuming elements.
The producer thread adds elements to the queue using put(), and the consumer thread retrieves elements from the queue
using take().
Since PriorityBlockingQueue maintains the order of elements based on their priority, the consumer thread will always
consume the lowest value available in the queue.
This example demonstrates how PriorityBlockingQueue provides a thread-safe, blocking implementation of a priority queue,
suitable for concurrent applications where elements need to be processed based on their priority.
*/