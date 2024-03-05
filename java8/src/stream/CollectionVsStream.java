package stream;

import java.util.ArrayList;
import java.util.stream.Stream;

public class CollectionVsStream {
    public static void main(String[] args) {
        ArrayList<String> names = new ArrayList<>();
        names.add("ashvani");
        names.add("akshay");
        names.add("ashi");
        names.add("ash");

        names.remove(0);
        names.remove("ash");
        System.out.println(names);


        ArrayList<Integer> integers = new ArrayList<>();
        integers.add(1);
        integers.add(2);
        integers.add(3);
        integers.add(4);
        integers.add(400);

        integers.remove(0);
        integers.remove(Integer.valueOf(400));
        System.out.println(integers);

        Stream<Integer> integerStream = integers.stream();
        //once stream prepared, we cant delete anything from it
    }
}
