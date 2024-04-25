package javaconcepts.inbuildDS.blockingQueue;

import java.util.Comparator;
import java.util.PriorityQueue;

public class PriorityQueueExample {
    public static void main(String[] args) {
        PriorityQueue<String> pq2 = new PriorityQueue<>(Comparator.reverseOrder());
        PriorityQueue<String> pq3 = new PriorityQueue<>(Comparator.comparing(String::toString).reversed());
        PriorityQueue<String> pq = new PriorityQueue<>(
                (a, b) -> -a.compareTo(b)
        );

        //pq1, pq2, pq3 all are doing same thing

        pq.add("b");
        pq.add("a");
        pq.add("c");
        pq.add("d");
        pq.add("aa");  //aa has more priority than b in lexicographical order [Dictionary]
        System.out.println(pq);
        System.out.println(pq.peek());
        pq.remove();
        System.out.println(pq);
        System.out.println(pq.peek());
        pq.remove();
        System.out.println(pq);
        System.out.println(pq.peek());
        pq.remove();
        System.out.println(pq);
    }
}
