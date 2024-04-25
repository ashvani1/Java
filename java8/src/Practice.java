import functionalInterfaces.data.Students;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class Practice {
    public static void main(String[] args) {

//        Optional.ofNullable(Students.studentSupplier.get()).filter(
//                student -> student.getName().startsWith("a")
//        ).orElseThrow(() -> new RuntimeException("no name start with a"));


        int[] ar = {1,2,3,4,5,6,7,8,9,10};
        /*Arrays.stream(ar).filter(
                a -> a%2 == 0
        ).forEach(System.out::println);*/

        int[] arr = Arrays.stream(ar).filter(a -> a%2 == 0).toArray();
        List<Integer> list = Arrays.stream(ar).filter(a -> a % 2 == 0).boxed().toList();

        //in single stream
        Map<Boolean, List<Integer>> result = Arrays.stream(ar).boxed().collect(Collectors.partitioningBy(a -> a % 2 == 0));

        for(Map.Entry<Boolean, List<Integer>> entry : result.entrySet()) {
            System.out.println("key " + entry.getKey());
            System.out.println("value " + entry.getValue());

        }

        System.out.println("*****");


    }
}
