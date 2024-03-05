package stream;

import functionalInterfaces.data.Student;
import functionalInterfaces.data.Students;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class StreamExample17 {
    static List<Student> studentList = Students.getAllStudents();

    //Find topper from each grade
    static Map<Integer, Optional<Student>> topGpaStudentInEachGrade() {
        Map<Integer, Optional<Student>> result = studentList.stream()
                .collect(Collectors.groupingBy(Student::getGradeLevel
                        ,Collectors.maxBy(Comparator.comparing(Student::getGpa))));
        return result;
    }

    //other way to do same thing, handle optional as well
    static Map<Integer, Student> topGpaStudentInEachGrade1() {
        Map<Integer, Student> result = studentList.stream()
                .collect(Collectors.groupingBy(Student::getGradeLevel,
                        Collectors.collectingAndThen(Collectors.maxBy(Comparator.comparing(Student::getGpa)),
                                Optional::get)
                        ));
        return result;
    }

    public static void main(String[] args) {
        for (Map.Entry entry : topGpaStudentInEachGrade().entrySet()) {
            System.out.println(entry.getKey() + " :: " + entry.getValue());
        }

    }
}
