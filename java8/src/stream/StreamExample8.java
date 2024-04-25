package stream;

import functionalInterfaces.data.Student;
import functionalInterfaces.data.Students;

import java.util.List;
import java.util.Optional;

public class StreamExample8 {
    static List<Student> students = Students.getAllStudents();

    static boolean allMatched() {
        return students.stream()
                .allMatch(student -> student.getGpa() > 10);
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

/*
findFirst(): This method returns the first element of the stream. If the stream is ordered, it returns the first element
encountered. In a parallel stream, findFirst() will return the first element in encounter order, which may not necessarily
 be the first element of the stream's source.

findAny(): This method returns any element of the stream. It's generally used in parallel streams where order is not important.
 In a sequential stream or an unordered parallel stream, findAny() behaves the same as findFirst() and returns the first
 element encountered. In an ordered parallel stream, it may not necessarily return the first element.*/