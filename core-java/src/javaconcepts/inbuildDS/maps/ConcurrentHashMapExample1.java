package javaconcepts.inbuildDS.maps;

import java.util.concurrent.ConcurrentHashMap;

import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMapExample1 {
    public static void main(String[] args) {
        // Create a ConcurrentHashMap
        ConcurrentHashMap<String, Integer> map = new ConcurrentHashMap<>();

        // Add elements to the map
        map.put("John", 30);
        map.put("Alice", 25);
        map.put("Bob", 35);

        // Modify the map concurrently using multiple threads
        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                System.out.println("Thread1-" + i);
                map.put("Thread1-" + i, i);
            }
        });

        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                System.out.println("Thread2-" + i);
                map.put("Thread2-" + i, i);
            }
        });

        // Start thread2 first
        thread2.start();

        try {
            // Wait for thread2 to complete
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Start thread1 after thread2 completes
        thread1.start();

        try {
            // Wait for thread1 to complete
            thread1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Print the map
        System.out.println("ConcurrentHashMap: " + map);
        System.out.println("map size "+map.size());
    }
}

//make only 1 thread completed fully before other thread
