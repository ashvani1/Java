package functionalInterfaces.methods;


import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class InterfaceMethodsExample1 {
    public static void main(String[] args) {
        //sort the list the name in alphabetical order

        List<String> stringList = Arrays.asList("ashvani", "shyam", "ram", "shoni", "abhi");

        //before java8
        //Collections.sort(stringList);
        System.out.println(stringList);

        //after Java8 => List interface has a default sort() method... [takes a comparator]
        stringList.sort(Comparator.reverseOrder());
        System.out.println(stringList);
    }
}
