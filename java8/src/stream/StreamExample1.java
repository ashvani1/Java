package stream;

import functionalInterfaces.data.Student;
import functionalInterfaces.data.Students;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamExample1 {
    static List<Student> students = Students.getAllStudents();
    public static void main(String[] args) {
        //Students name and activities in a map
        Map<String, List<String>> studentWithActivities = students.stream().collect(Collectors.toMap(Student::getName, Student::getActivities));
        /*Collectors.toMap() : Returns a Collector that accumulates elements into a Map whose keys and values are the
         result of applying the provided mapping functions to the input elements.. means toMap is taking 2 function.*/

        //System.out.println(studentWithActivities);


        /*for filtering on stream we have function method which takes predicate*/
        List<Student> studentsWithGradeGreaterThanFive = students.stream().filter(student -> student.getGradeLevel() > 5).collect(Collectors.toList());

        //only name
        List<String> studentsNameWithGradeGreaterThanFive =
                students.stream().filter(student -> student.getGradeLevel() > 5).map(student -> student.getName()).collect(Collectors.toList());

        //Above one can be simplified as
        List<String> studentsNameWithGradeGreaterThanFiveWithMethodReference =
                students.stream().filter(student -> student.getGradeLevel() > 5).map(Student::getName).toList();

        //System.out.println(studentsNameWithGradeGreaterThanFive);

        //In dev, we can debug stream using peak() method which take a consumer
        students.stream().peek(System.out::println)
                .filter(student -> student.getGpa()>5)
                .peek(student -> System.out.println("after first filter result is "+student))
                .filter(student -> student.getGradeLevel() > 10)
                .peek(student -> System.out.println("after second filter result is "+student))
                .forEach(System.out::println);
    }
}
