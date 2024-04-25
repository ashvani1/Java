package javaconcepts.inbuildDS.concurrentCollections;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class ConcurrentExceptionAndPrevention {
    public static void main(String[] args) {
        //below code will work
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            numbers.add(i);
        }
        List<Integer> modifiedNumbers =
                numbers.parallelStream()
                        .flatMap(
                                num -> {
                                    List<Integer> temp = new ArrayList<>();
                                    if (num % 2 == 0) {
                                        temp.add(num * 10);
                                    }
                                    return temp.stream();
                                })
                        .toList();
        System.out.println("Modified numbers: " + modifiedNumbers);


        //we can use concurrent collection
        CopyOnWriteArrayList<Integer> list = new CopyOnWriteArrayList<>();
        numbers.parallelStream().forEach(
                a -> {
                    if (a % 2 == 0) {
                        list.add(a * 10);
                    }
                }
        );
        System.out.println("CopyOnWriteArrayList " + list);


        // Simulate concurrent modification using parallel stream
        List<Integer> numbers1 = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            numbers1.add(i);
        }
        numbers1.parallelStream()
                .forEach(num -> {
                    if (num % 2 == 0) {
                        numbers1.add(num * 10); // This will throw ConcurrentModificationException
                    }
                });
    }
}

//here we use parallel streams along with side-effect operations that modify the underlying data structure
//we are trying to add elements to the list based on a condition (num % 2 == 0). Since the stream operates concurrently,
//it may attempt to modify the list while other modifications are in progress, leading to a concurrent modification exception
//(ConcurrentModificationException). This exception occurs because the underlying list is modified while it is being iterated
//over by the parallel stream, violating the fail-fast behavior of the collections framework.