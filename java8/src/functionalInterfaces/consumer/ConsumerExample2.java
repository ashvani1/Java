package functionalInterfaces.consumer;
import functionalInterfaces.data.Student;
import functionalInterfaces.data.Students;

import java.util.*;
import java.util.function.Consumer;

public class ConsumerExample2 {
    static Consumer<Student> consumer1 = (student) -> {
        System.out.println(student.getName());
    };
    static Consumer<Student> consumer2 = (student) -> {
        System.out.println(student.getActivities());
    };
    public static void print(List<Student> students) {
        System.out.println(students);
    }

    public static void printStudentsName() {

        //foreach method accepts consumer implementation by default
        Students.getAllStudents().forEach(consumer1);
    }

    public static void printStudentNamesWithActivities() {
        Students.getAllStudents().forEach(consumer1.andThen(consumer2));

    }

    public static void studentsWithGradeGreaterThanTwo() {
        Students.getAllStudents()
                .forEach(               //in actual forEach takes each element from list/stream and do operation on each
                student -> {
                    if(student.getGradeLevel() > 2) {
                        consumer1.andThen(consumer2).accept(student);
                    }
                }
        );

    }
    public static void main(String[] args) {
        //print(Students.getAllStudents());
        //printStudentsName();
        //printStudentNamesWithActivities();
        studentsWithGradeGreaterThanTwo();
    }
}
//anThen is used for consumer chaining
//If we need 2 inputs, we have BiConsumer