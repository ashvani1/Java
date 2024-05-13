package stream;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class StreamExample6 {
    static List<Integer> numbers = Arrays.asList(1,2,43534,4543,1,1,243453,1210);

    static Optional<Integer> findMaxUsingReduce() {
        return numbers.stream().reduce(
                (x, y) -> x>y ? x:y
        );
    }
    static Optional<Integer> findMaxUsingMaxOperator() {
        //return numbers.stream().max((x, y) -> x.compareTo(y)); similar
        return numbers.stream().max(Integer::compareTo);
    }

    static Optional<Integer> findMinUsingMaxOperator() {
        //return numbers.stream().max((x, y) -> x.compareTo(y)); similar
        return numbers.stream().min(Integer::compareTo);
    }

    void findSum() {
        int sum1 = numbers.stream().mapToInt(Integer::intValue).sum();
        int sum2 = numbers.stream().reduce(0, (a,b) -> a+b);
        int sum3 = numbers.stream().reduce(0, Integer :: sum);
    }
    public static void main(String[] args) {
        System.out.println(findMaxUsingReduce());
        System.out.println(findMinUsingMaxOperator());

    }
}
