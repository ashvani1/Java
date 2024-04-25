package optional;

import java.util.Optional;

//isPresent
//ifPresent
public class OptionalExample3 {
    public static void main(String[] args) {
        Optional<String> optional = Optional.ofNullable("Hello");
        System.out.println(optional.isPresent());           //check whether optional has some value or not

        Optional<String> optional1 = Optional.ofNullable(null);
        System.out.println(optional1.isPresent());

        //ifPresent() take a consumer
        optional.ifPresent(a -> System.out.println(a));   //print Hello
        optional1.ifPresent(a -> System.out.println(a));  // dont print anything as optional1 doesn't have anything

        System.out.println(optional.isPresent());


    }
}
