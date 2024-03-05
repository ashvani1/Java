package functionalInterfaces.methods;

import java.util.List;

public class MultiplierImpl implements Multiplier{
    @Override
    public int multiply(List<Integer> integers) {
        return integers.stream().reduce(1, (a, b) -> a*b);
    }

    //default methods of interface can be overridden
    //access modifier can only be public here, not protected/default/private
    @Override
     public int size(List<Integer> list) {
        System.out.println("Inside MultiplierImpl :: size()");
        return list.size();
    }
}
