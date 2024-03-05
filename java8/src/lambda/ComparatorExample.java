package lambda;

import java.util.Comparator;

public class ComparatorExample {
    public static void main(String[] args) {
        //Comparator has compare(T o1, T o2); which compares its two arguments for order. Returns a negative integer, zero,
        // or a positive integer as the first argument is less than, equal to, or greater than the second.

        //Without Lambda
        Comparator<Integer> comparator = new Comparator<>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                //returns 0 for o1 = o2, returns 1 for o1 > o2, // returns -1 for o1 < o2
                return o1.compareTo(o2);                 //this we are able to do because Comparator is of Integer type not Object
            }
        };
        System.out.println("comparator "+ comparator.compare(1,2));


        //with Lambda
        Comparator<Integer> comparator1 = (a, b) -> {
            return a.compareTo(b);
        };
        System.out.println("comparator1 "+ comparator.compare(1,2));
    }
}
