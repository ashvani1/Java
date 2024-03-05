package stream;

import functionalInterfaces.data.Student;
import functionalInterfaces.data.Students;

import java.util.List;
import java.util.stream.Collectors;

//terminal operators: counting()
public class StreamExample11 {
    static List<Student> studentList = Students.getAllStudents();

    static long studentNameStartWithACount() {
        return studentList.stream().
                filter(student -> student.getName().startsWith("aa"))
                .collect(Collectors.counting());

    }

    public static void main(String[] args) {
        System.out.println(studentNameStartWithACount());

    }
}
