package functionalInterfaces.predicate;

public class Introduction {
    //Represents a predicate (boolean-valued function) of one argument.
    //It has test(), and(), or()
    //boolean test(T t) :  t is input and return true if it passed on predicated
    //Predicate<T> and(Predicate<? super T> other) : logical AND operation with another predicate
    //Predicate<T> or(Predicate<? super T> other) : logical OR
    //default Predicate<T> negate() : reverse the predicate

    //as Predicate gives a boolean result, we can pass it to the places where we need boolean result like
    //  if(predicate.get(object)), filter(predicate)
}
