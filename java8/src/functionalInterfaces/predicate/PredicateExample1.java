package functionalInterfaces.predicate;

import java.util.function.Predicate;

public class PredicateExample1 {
    public static void main(String[] args) {
        //check if given number is even or not
        Predicate<Integer> evenPredicate = (number) -> number % 2 == 0;
        Predicate<Integer> divisibleByFive = (number) -> number % 5 == 0;

        System.out.println("3 is even :"+evenPredicate.test(3));
        System.out.println("2 is even :"+evenPredicate.test(2));
        System.out.println("20 is even and divisible by 5 :"+evenPredicate.and(divisibleByFive).test(20));
        System.out.println("22 is even and divisible by 5 :"+evenPredicate.and(divisibleByFive).test(22));
        System.out.println("22 is divisible by 5 or by 2 :"+evenPredicate.or(divisibleByFive).test(22));
        System.out.println("22 is divisible by 5 or by 2 with negate() :"+evenPredicate.or(divisibleByFive).negate().test(22));
    }
}
