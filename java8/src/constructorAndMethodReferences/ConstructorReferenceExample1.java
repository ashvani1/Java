package constructorAndMethodReferences;

import functionalInterfaces.data.Student;

import java.util.function.Supplier;

public class ConstructorReferenceExample1 {
    public static void main(String[] args) {
        Supplier<Student> student = Student::new; //can call only default constructor
    }
}
