package stream;

import functionalInterfaces.data.Student;
import functionalInterfaces.data.Students;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

//focused on Sorted techniques in Stream
public class StreamExample3 {
    static List<Student> studentList = Students.getAllStudents();

    static List<Student> studentsSortedByName() {
        return studentList.stream()
                .sorted(Comparator.comparing(Student::getName))                           //sorted looks for Comparator
                .collect(Collectors.toList());
    }
    public static void main(String[] args) {
        //System.out.println("Students sorted by name");
        //studentsSortedByName().forEach(System.out::println);
        //good example of sorting: must
        studentList.stream().sorted(Student.studentComparator).forEach(System.out::println);

    }
}
