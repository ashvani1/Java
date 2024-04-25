package javaconcepts.inbuildDS.concurrentCollections;

import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CopyOnWriteArrayListExample {

    public static void main(String[] args) {
        CopyOnWriteArrayList<Integer> list = new CopyOnWriteArrayList<>();
        ExecutorService executor = Executors.newFixedThreadPool(2);

        executor.submit(() -> {
            for (int i = 0; i < 100; i++) {
                list.add(i);
            }
        });

        executor.submit(() -> {
            for (int i = 0; i < 100; i++) {
                list.add(i*1000);
            }
        });

        executor.shutdown();
        while (!executor.isTerminated()) { }

        for(Integer integer : list) {
            System.out.println(integer);
        }

        System.out.println("List size: " + list.size());
    }
}

