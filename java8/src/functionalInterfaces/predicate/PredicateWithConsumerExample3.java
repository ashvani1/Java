package functionalInterfaces.predicate;

import functionalInterfaces.data.Student;
import functionalInterfaces.data.Students;

import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class PredicateWithConsumerExample3 {
    static Predicate<Student> topGrades = (student) -> student.getGradeLevel() > 5;
    static Predicate<Student> goodGPA = (student) -> student.getGpa() > 60;
    static BiPredicate<Integer, Double> topGradeWithGodGPA = (grade, gpa) -> grade > 5 && gpa > 60;
    static BiConsumer<Student, List<String>> biConsumer = ((student, activities) ->
            System.out.println("student : " +student + " activities :" + activities));

    static void printStudentNamesWithActivities(List<Student> studentList) {

        //consumer doesn't return anything, here it will just apply the given conditions to the input
        Consumer<Student> consumer = (student) -> {
            if(topGrades.and(goodGPA).test(student)) {
                biConsumer.accept(student, student.getActivities());

            }
        };
        //consumer has the logic, but it has to be applied on some data
        studentList.forEach(consumer);

        //forEach is terminal operator so we cant collect it and store it like filter()
        studentList.stream().forEach(consumer);

        //BiPredicate
//        studentList.forEach(
//                student -> {
//                    if(topGradeWithGodGPA.test(student.getGradeLevel(), student.getGpa())) {
//                        biConsumer.accept(student, student.getActivities());
//                    }
//                }
//        );
    }
    public static void main(String[] args) {
        printStudentNamesWithActivities(Students.getAllStudents());

    }
}
