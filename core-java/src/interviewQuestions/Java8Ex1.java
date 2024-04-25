package interviewQuestions;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Java8Ex1 {
    public static void main(String[] args) {
        Stream.of(1,2,3,4,5,6,7,8).filter(
                a -> a%2 == 0
        ).forEach(System.out::println);

        Stream.of(1,2,3,4,5,6,7,8).filter(
                a -> a%2 == 0
        ).collect(Collectors.toList());

        int[] ar = {1,2,3,4,5,6,7,8,9};
        Arrays.stream(ar).filter(
                a -> a%2 == 0
        ).boxed().collect(Collectors.toList());
    }
}
