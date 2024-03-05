package stream;

import java.util.Random;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class StreamExample9 {
    public static void main(String[] args) {
        Stream<Integer> integerStream = Stream.of(1,34,23,456);
        //integerStream.forEach(System.out::println);

        Stream<Integer> integerStreamUsingIterate = Stream.iterate(1, x-> x*2).limit(10);
        //integerStreamUsingIterate.forEach(System.out::println);

        Supplier<Integer> integerSupplier = new Random()::nextInt;
        Stream.generate(integerSupplier).limit(5).forEach(System.out::println);
    }
}
