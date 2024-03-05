package constructorAndMethodReferences;

import functionalInterfaces.data.Student;
import functionalInterfaces.data.Students;

import java.util.function.Consumer;
import java.util.function.Function;

public class MethodReferenceExample1 {
    public static void main(String[] args) {
        Function<String, String> toLowerCase =  input -> input.toLowerCase();
        Function<String, String> toLowerCaseWithMethodReference =  String::toLowerCase;
        System.out.println(toLowerCaseWithMethodReference.apply("ASHVANI"));

        Consumer<Student> consumer = System.out :: println;
        Students.getAllStudents().forEach(consumer);

    }
}


