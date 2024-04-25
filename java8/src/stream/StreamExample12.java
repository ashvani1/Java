package stream;

import functionalInterfaces.data.Student;
import functionalInterfaces.data.Students;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

//minBy(), maxBy(), summingInt(), averagingInt()
public class StreamExample12 {
    static List<Student> studentList = Students.getAllStudents();


    //find a Student having minimum GPA
     static Optional<Student> minBy() {
         return studentList.stream()
                         .filter(student -> student.getName().startsWith("a"))
                 //collect(Collectors.minBy(Comparator.comparing(Student::getGpa)));   //comparing is from Collectors
                 .min(Comparator.comparing(Student::getGpa));                          //min is from ReferencePipeline
    }
    public static void main(String[] args) {
         minBy().stream().forEach(System.out::println);
        Optional<Integer> minimum = Arrays.asList(10,2,3,5,610, 32).stream().min(Integer :: compareTo);
        minimum.ifPresent(System.out::println);

    }
}
