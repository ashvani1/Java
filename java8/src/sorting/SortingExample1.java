package sorting;


import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class SortingExample1 {
    public static void main(String[] args) {
        //sort the list the name in alphabetical order

        List<String> stringList = Arrays.asList("ashvani", "shyam", "ram", "shoni", "abhi");

        //before java8
        //Collections.sort(stringList);
        System.out.println(stringList);

        //after Java8 => List interface has a default sort() method... [takes a comparator]
        stringList.sort(Comparator.reverseOrder());
        System.out.println(stringList);

        stringList.sort(Comparator.naturalOrder());
        System.out.println(stringList);

        stringList.sort(Comparator.comparing(String::toLowerCase));
        System.out.println(stringList);

        //for primitive data
        int[] a = {2,1,3,5,3,5,10,7,5,3,1,0};
        Arrays.sort(a);
        Arrays.stream(a).forEach(System.out::print);
    }
}
