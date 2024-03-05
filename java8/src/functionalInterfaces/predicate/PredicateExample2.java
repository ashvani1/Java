package functionalInterfaces.predicate;
import java.util.*;
import java.util.function.Predicate;

import functionalInterfaces.data.Student;
import functionalInterfaces.data.Students;

public class PredicateExample2 {
    public static List<Student> students = Students.getAllStudents();
    public static Predicate<Student> getStudentsWithGoodGrades = (student) -> student.getGradeLevel() > 10;
    public static void filterStudentsByGrade() {
        students.forEach( (student) -> {
                    if(getStudentsWithGoodGrades.test(student)) {
                        System.out.println("student having grades greater than-1 :"+student.getName());
                    }
                }
        );
    }

    public static List<Student> filterStudentsByGrades() {
        //filter takes predicate
        return students.stream().filter(getStudentsWithGoodGrades).toList();

    }
    public static void main(String[] args) {
        //filterStudentsByGrade();
        System.out.println(filterStudentsByGrades());

    }
}
