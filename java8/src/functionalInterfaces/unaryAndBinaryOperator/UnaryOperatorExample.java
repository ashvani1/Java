package functionalInterfaces.unaryAndBinaryOperator;

import java.util.function.UnaryOperator;

public class UnaryOperatorExample {
    public static void main(String[] args) {
        UnaryOperator<String> toUpperCase = String::toUpperCase;
        System.out.println(toUpperCase.apply("ashvani"));
    }
}
