package functionalInterfaces.Supplier;

import functionalInterfaces.data.Student;

import java.util.Arrays;
import java.util.function.Supplier;

public class SupplierExample1 {
    public static void main(String[] args) {
        Supplier<Student> studentSupplier = () ->{
            return new Student("Aadi", 9, 92,"Male", Arrays.asList("swimming", "cricket", "bowling"), 11);
        };

        Supplier<String> myS = () -> {return "ashvani";};

        System.out.println(studentSupplier.get());
        System.out.println(myS.get());
    }
}
