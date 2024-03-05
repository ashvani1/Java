package functionalInterfaces.methods;

import java.util.List;

public interface Multiplier {
    int multiply(List<Integer> integers);

    default int size(List<Integer> list) {
        System.out.println("Inside Multiplier :: size()");
        return list.size();
    }

    static String details() {
        return "this is a multiplication utility";
    }
}
