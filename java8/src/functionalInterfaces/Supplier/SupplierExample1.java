package functionalInterfaces.Supplier;

import functionalInterfaces.data.Student;

import java.util.Arrays;
import java.util.function.Supplier;

public class SupplierExample1 {
    public static void main(String[] args) {
        Supplier<Student> studentSupplier = () ->{
            return new Student("Aadi", 9, 92,"Male", Arrays.asList("swimming", "cricket", "bowling"), 11);
        };

        System.out.println(studentSupplier.get());
    }
}
