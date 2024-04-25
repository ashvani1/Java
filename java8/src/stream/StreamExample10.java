package stream;

import functionalInterfaces.data.Student;
import functionalInterfaces.data.Students;

import java.util.List;
import java.util.stream.Collectors;

//terminal operators: joining
public class StreamExample10 {
    static List<Student> studentList = Students.getAllStudents();

    static String joiningStudentNames() {
        return studentList.stream()
                .map(Student::getName)
                .collect(Collectors.joining());
    }

    static String joiningStudentNames2() {  //with delimiter
        return studentList.stream()
                .map(Student::getName)
                .collect(Collectors.joining("-"));
    }

    static String joiningStudentNames3() { //with delimiter, prefix and suffix
        return studentList.stream()
                .map(Student::getName)
                .collect(Collectors.joining("-", "{", "}"));
    }

    static String joiningStudentNames4() {  //with delimiter
        return studentList.stream()
                .map(Student::getName)
                .collect(Collectors.joining(" "));
    }

    public static void main(String[] args) {
        System.out.println(joiningStudentNames4());
    }
}
