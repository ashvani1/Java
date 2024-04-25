package interviewQuestions;

import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.*;

public class Qn1 {
    public static void main(String[] args) {
        //In imperative we would have done this using for loop and sum each element

        //generate sum of 100 numbers
        System.out.println(IntStream.rangeClosed(0, 100).sum());
        //parallel programming
        System.out.println(IntStream.rangeClosed(0, 100).parallel().sum());

        //remove duplicates
        List<Integer> list = Arrays.asList(1,2,3,4,5,6,6,6,7);
        list = list.stream().distinct().collect(Collectors.toList());
        System.out.println(list);

    }
}
