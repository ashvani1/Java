package javaconcepts.inbuildDS.concurrentCollections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
public class ConcurrentHashMapExample {
    public static void main(String[] args) {
        ConcurrentHashMap<String, Integer> map = new ConcurrentHashMap<>();
        ExecutorService executor = Executors.newFixedThreadPool(2);

        executor.submit(() -> {
            for (int i = 0; i < 1000; i++) {
                map.put("Key" + i, i);
            }
        });

        executor.submit(() -> {
            for (int i = 0; i < 1000; i++) {
                map.put("Key-" + i, i * 10);
            }
        });

        executor.shutdown();

        //will work as join() and prevent main threads until above task completed
        while (!executor.isTerminated()) {
        }


        // Print key-value pairs
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
        }
        //from the output it is clean that both threads are running concurrently on map.
        //both threads are accessing map and adding some values to it

        System.out.println("Map size: " + map.size());
    }
}


