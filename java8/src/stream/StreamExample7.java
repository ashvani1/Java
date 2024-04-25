package stream;


import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class StreamExample7 {

    static List<Integer> numbers = Arrays.asList(1, 23, 432, -4534, 53, 5, 43, 1, 34, 23, 54);

    static Optional<Integer> findSumOfFirstFiveElements() {
        return numbers.stream()
                .limit(5)
                .reduce((a, b) -> a + b);
    }

    static Optional<Integer> skipFirstFiveElementsAndThenSumRest() {
        return numbers.stream().skip(5).reduce((a, b) -> a + b);
    }

    public static void main(String[] args) {
        System.out.println(skipFirstFiveElementsAndThenSumRest());

    }
}
