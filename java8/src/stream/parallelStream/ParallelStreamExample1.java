package stream.parallelStream;

import java.time.Instant;
import java.util.stream.IntStream;

public class ParallelStreamExample1 {

    static int sumSequencially() {
        return IntStream.rangeClosed(1, 1000000).sum();
    }

    static int sumParallelly() {
        return IntStream.rangeClosed(1, 1000000).parallel().sum();
    }

    static void doLoopSequencially() {
        for(int i = 0; i < 100; i++) {
            sumSequencially();
        }
    }

    static void doLoopParallely() {
        for(int i = 0; i < 100; i++) {
            sumParallelly();
        }
    }
    public static void main(String[] args) {
        long beforeExecution = System.currentTimeMillis();
        doLoopSequencially();
        long afterExecution = System.currentTimeMillis();
        long totalTime = afterExecution - beforeExecution;
        System.out.println("Total time in sequential sum :" + totalTime);

        long beforeExecution1 = System.currentTimeMillis();
        doLoopParallely();
        long afterExecution1 = System.currentTimeMillis();
        long totalTime1 = afterExecution1 - beforeExecution1;
        System.out.println("Total time in parallel sum :" + totalTime1);


        System.out.println(Runtime.getRuntime().availableProcessors());


        //Interesting here IntStream.rangeClosed(1, 1000000) is giving better result with parallel stream but
        //IntStream.rangeClosed(1, 10000) is giving better result with sequence stream

    }
}
