package functionalInterfaces.methods;

import java.util.Arrays;
import java.util.List;

public class MultiplierClient {
    public static void main(String[] args) {
        Multiplier multiplier = new MultiplierImpl();
        List<Integer> list = Arrays.asList(1,2,24,32,24,2);
        System.out.println(multiplier.multiply(list));

        //default methods called with object reference
        System.out.println(multiplier.size(list));

        //static methods called with Class name
        System.out.println(Multiplier.details());
    }
}
