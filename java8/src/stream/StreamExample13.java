package stream;

import functionalInterfaces.data.Student;
import functionalInterfaces.data.Students;

import java.util.List;
import java.util.stream.Collectors;

public class StreamExample13 {
    static List<Student> studentList = Students.getAllStudents();

    public static int sum() {
        return studentList.stream()
                .collect(Collectors.summingInt(Student::getNoteBooks));
    }

    public static Double average() {
        return studentList.stream()
                .collect(Collectors.averagingInt(Student::getNoteBooks));
    }
    public static void main(String[] args) {
        System.out.println(sum());
        System.out.println(average());

    }
}
