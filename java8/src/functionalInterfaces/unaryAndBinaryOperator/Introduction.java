package functionalInterfaces.unaryAndBinaryOperator;

public class Introduction {
    //UnaryOperator
    //This is a specialization of Function for the case where the operand and result are of the same type.
    //methods : identity() => a unary operator that always returns its input argument
    //As it extends Function interface, all function interface methods are available

    //BinaryOperator
    //This is similar to biFunction where both input arguments are return type are of similar type
    //It has 2 additional methods minBy() and maxBy()
    //minBy() => Returns a BinaryOperator which returns the lesser of two elements according to the specified Comparator.
    //maxBy() => Returns a BinaryOperator which returns the greater of two elements according to the specified Comparator.
}
