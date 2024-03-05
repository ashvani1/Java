package stream.numericStreams;

import functionalInterfaces.data.Student;
import functionalInterfaces.data.Students;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

//terminal operators: mapping()
public class StreamExample12 {
    static List<Student> studentList = Students.getAllStudents();

    //apply map logic passed by mapping before collecting
    static Set<String> mappingExample() {
        return studentList.stream().
                collect(
                        Collectors.mapping(student -> student.getName().toUpperCase(),
                                Collectors.toSet()));

        // return studentList.stream().map(student -> student.getName().toUpperCase()).collect(Collectors.toList()); //similar to above
    }

    public static void main(String[] args) {
        mappingExample().stream().forEach(System.out::println);

    }
}
