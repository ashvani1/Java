package javaconcepts.inbuildDS.blockingQueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ArrayBlockingQueueExample {
    public static void main(String[] args) {
        BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(5);

        // Producer thread
        Thread producer = new Thread(() -> {
            try {
                for (int i = 20; i > 0; i--) {
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
                for (int i = 0; i < 20; i++) {
                    int value = queue.take(); // Retrieve elements from the queue, FIFO
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
We create a BlockingQueue implementation (ArrayBlockingQueue) with a capacity of 5.
We start two threads: one for producing elements and another for consuming elements.
The producer thread adds elements to the queue using put(), and the consumer thread retrieves elements from the queue
using take().
If the queue is full, the producer will block until space becomes available. Similarly, if the queue is empty, the
consumer will block until an element becomes available.
This example demonstrates how BlockingQueue provides thread-safe, blocking operations for inter-thread communication
and synchronization.

*/