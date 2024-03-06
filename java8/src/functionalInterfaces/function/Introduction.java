package functionalInterfaces.function;

public class Introduction {
    //Represents a function that accepts one argument and produces a result.
    //Methods- apply(), andThen(), compose()
    /*
    * compose(function)   => first apply the function passed in it and then apply the first function
    * andThen(function)   => first apply the first function and then next one
    * apply(input)        => applies logic on given input and collect result based on the type defined in function definition
    * */


    /*
    R apply(T t): Applies this function to the given argument.
    default <V> Function<T, V> andThen(Function<? super R, ? extends V> after): first applies this function to its input,
     and then applies the after function to the result...




    //BiFunction : takes 2 inputs and return 1 output
    //it has only 2 method, apply(), andThen()
    */
}
