package functionalInterfaces.function;
import java.util.function.Function;

public class FunctionExample1 {
     static Function<String, String> toUpperCase = String::toUpperCase;
     static Function<String, String> concatWithDefault = (s1) -> s1.concat(" concatenating default");
     static Function<String, Integer> findStringLength = String::length;



    public static void main(String[] args) {
        String s1 = "ashvanI";
        System.out.println(toUpperCase.apply(s1));
        System.out.println(findStringLength.apply(s1));
        //first uppercase then concat
        System.out.println(toUpperCase.andThen(concatWithDefault).apply(s1));
        //first concat then upper case
        System.out.println(toUpperCase.compose(concatWithDefault).apply(s1));

        //we have compose() function which first apply the function passed in it and then apply the first function

    }
}
