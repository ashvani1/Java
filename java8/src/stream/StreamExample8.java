package stream;

import functionalInterfaces.data.Student;
import functionalInterfaces.data.Students;

import java.util.List;
import java.util.Optional;

public class StreamExample8 {
    static List<Student> students = Students.getAllStudents();

    static boolean allMatched() {
        return students.stream().allMatch(student -> student.getGpa()>10);
    }

    static Optional<Student> findFirstStudentWithNameAsAshvani() {
        return students.stream()
                .filter(student -> student.getName().equals("ashvani"))
                .findFirst();
    }

    static Optional<Student> findAnyStudentWithNameAsAshvani() {
        return students.stream()
                .filter(student -> student.getName().equals("ashvani"))
                .findAny();
    }
    public static void main(String[] args) {
        //System.out.println(allMatched());
        System.out.println(findFirstStudentWithNameAsAshvani());
        System.out.println(findAnyStudentWithNameAsAshvani());
    }
}
