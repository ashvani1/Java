package stream.numericStreams;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;

public class NumericStreamExample1 {
    static int sum(List<Integer> numbers) {
        return numbers.stream().
                reduce(0, Integer::sum); //sum() takes primitive int and return int so here we have additional unboxing
    }

    static Optional<Integer> sum1(List<Integer> numbers) {
        return numbers.stream().
                reduce(Integer::sum);
    }

    static int sumOfIntStream() {
        return IntStream
                .rangeClosed(1, 6)         //1,2,3,4,5,6
                .sum();
    }



    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1,2,3,4,5,6);
        System.out.println(sum(numbers));
        System.out.println(sum1(numbers).get());
        System.out.println(sumOfIntStream());
    }
}
