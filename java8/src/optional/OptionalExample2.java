package optional;

import functionalInterfaces.data.Student;
import functionalInterfaces.data.Students;

import java.util.Optional;

//orElse()
//orElseGet()
//orElseThen()
public class OptionalExample2 {
    public static String optionalOrElse() {
        Optional<Student> studentOptional
                = Optional.ofNullable(Students.studentSupplier.get());
        String name
                = studentOptional.map(Student::getName)
                .filter(student ->student.startsWith("a"))
                .orElse("Default");
        return name;
    }

    public static String optionalOrElseGet() {
        Optional<Student> studentOptional
                = Optional.ofNullable(Students.studentSupplier.get());
        String name
                = studentOptional.map(Student::getName)
                .filter(student ->student.startsWith("a"))
                .orElseGet(() -> "Default");         //orElseGet() it needs Supplier, we can set it as per requirement
                                                    //orElseGet() can be useful when method is returning custom objects like Student etc
        return name;
    }

    public static String optionalOrElseThrow() {
        Optional<Student> studentOptional
                = Optional.ofNullable(Students.studentSupplier.get());
        String name
                = studentOptional.map(Student::getName)
                .filter(student ->student.startsWith("a"))
                .orElseThrow(() -> new RuntimeException("Student name is not starting with a"));

        //orElseThrow() takes a Supplier and it is useful where we want to throw an exception is data not found
        return name;
    }
    public static void main(String[] args) {
        System.out.println(optionalOrElse());
        System.out.println(optionalOrElseGet());
        System.out.println(optionalOrElseThrow());
    }
}
