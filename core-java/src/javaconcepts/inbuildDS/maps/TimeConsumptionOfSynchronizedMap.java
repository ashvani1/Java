package javaconcepts.inbuildDS.maps;

import java.time.Duration;
import java.time.Instant;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class TimeConsumptionOfSynchronizedMap {
    public static void main(String[] args) {
        Instant startTime = Instant.now();
        System.out.println("***************" + startTime);
        // Create a synchronized map
        Map<String, Integer> synchronizedMap = Collections.synchronizedMap(new HashMap<>());

        // Add elements to the synchronized map
        synchronizedMap.put("John", 30);
        synchronizedMap.put("Alice", 25);
        synchronizedMap.put("Bob", 35);

        // Modify the synchronized map concurrently using multiple threads
        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                synchronizedMap.put("Thread1-" + i, i);
            }
        });

        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                synchronizedMap.put("Thread2-" + i, i);
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

        // Print the synchronized map
        System.out.println("Synchronized Map: " + synchronizedMap);
        Instant endTime = Instant.now();
        System.out.println("***************" + endTime);
        Duration duration = Duration.between(startTime, endTime);
        System.out.println("duration "+ duration);  //PT0.014924S
    }
}

