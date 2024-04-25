package javaconcepts.inbuildDS.maps;

import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.ConcurrentHashMap;

public class TimeConsumptionOfConcurrentHashMap {
    public static void main(String[] args) throws InterruptedException {
        Instant startTime = Instant.now();
        System.out.println("***************" + startTime);
        // Create a ConcurrentHashMap
        ConcurrentHashMap<String, Integer> map = new ConcurrentHashMap<>();

        // Add elements to the map
        map.put("John", 30);
        map.put("Alice", 25);
        map.put("Bob", 35);

        // Modify the map concurrently using multiple threads
        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                map.put("Thread1-" + i, i);
                //System.out.println(map);
            }
        });

        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                map.put("Thread2-" + i, i);
                //System.out.println(map);
            }
        });
        // Start the threads
        thread1.start();

        thread2.start();

        try {
            // Wait for threads to complete
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Print the map
        System.out.println("ConcurrentHashMap: " + map);
        Instant endTime = Instant.now();
        System.out.println("***************" + endTime);
        Duration duration = Duration.between(startTime, endTime);
        System.out.println("duration "+ duration);  //PT0.008576S
    }
}

/*
The main thread (presumably the thread executing the main() method) will wait for thread1 and thread2 to complete their
execution before proceeding.

Here's how it works:

When thread1.join() is called, the main thread will pause its execution and wait for thread1 to complete.
Similarly, when thread2.join() is called, the main thread will pause again and wait for thread2 to complete.
Effectively, the main thread is waiting for both thread1 and thread2 to finish their execution before it continues with
its own execution. This ensures that any modifications made by thread1 and thread2 to shared data structures
(such as the ConcurrentHashMap in this case) are visible and complete before the main thread continues processing or
printing the final result.

In summary, the join() method allows threads to synchronize their execution, ensuring that certain actions are completed
before proceeding with others.*/