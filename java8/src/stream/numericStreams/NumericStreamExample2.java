package stream.numericStreams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class NumericStreamExample2 {
    static void boxing() {
        Stream<Integer> value = IntStream.rangeClosed(1, 6)         //int Stream
                .boxed();                                           //Integer Stream

        List<Integer> list = value.filter(a -> a > 2).collect(Collectors.toList());
        System.out.println(list);

        int[] a = {1,2,3,4,5,6};
        Stream<Integer> ar = Arrays.stream(a).filter(a1 -> a1 % 2 == 0).boxed();
        List<Integer> even = ar.toList();

        IntStream ar1 = Arrays.stream(a).filter(a1 -> a1 % 2 != 0);
        int[] odd = ar1.toArray();

        System.out.println("even numbers");
        System.out.println(even);

        System.out.println("odd numbers");
        System.out.println( Arrays.toString(odd));
    }

    static void unBoxing() {
        Stream<Integer> stream = Stream.of(1, 2, 3, 4, 5, 6);
        IntStream newStream = stream.mapToInt(Integer::intValue);
        newStream.forEach(System.out::println);
    }

    public static void main(String[] args) {
        boxing();
        //unBoxing();

    }
}
