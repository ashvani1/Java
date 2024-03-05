package functionalInterfaces.unaryAndBinaryOperator;

import java.util.Comparator;
import java.util.function.BinaryOperator;

public class BinaryOperatorExample {
    static BinaryOperator<Integer> multiplication = (a, b) -> a*b;
    static Comparator<Integer> comparator = Integer::compareTo; //similar to (a, b) -> a.compareTo(b);
    public static void main(String[] args) {

        System.out.println("multiplication of 4234 and 24 is "+ multiplication.apply(4234, 24));

        //This will give maximum value between 2 inputs
        BinaryOperator<Integer> maxBy = BinaryOperator.maxBy(comparator);
        System.out.println("max: " + maxBy.apply(1314,2121));

        //This will give minimum value between 2 inputs
        BinaryOperator<Integer> minBy = BinaryOperator.minBy(comparator);
        System.out.println("min :" + minBy.apply(1314,2121));

    }
}
