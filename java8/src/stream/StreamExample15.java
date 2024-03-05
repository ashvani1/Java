package stream;

import functionalInterfaces.data.Student;
import functionalInterfaces.data.Students;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

//groupingBY(two param)
public class StreamExample15 {
    static List<Student> studentList = Students.getAllStudents();
    static Map<Integer, Map<String, List<Student>>> twoLevelMappingExample1() {
        return studentList.stream()
                .collect(Collectors.groupingBy(Student::getGradeLevel,
                        Collectors.groupingBy(student -> student.getGpa() > 91 ? "OUTSTANDING" : "AVERAGE")));
    }

    static Map<String, Integer>  twoLevelMappingExample2() {
        Map<String, Integer> result = studentList.stream()
                .collect(Collectors.groupingBy(Student::getName,
                        Collectors.summingInt(Student::getNoteBooks)));
        return result;
    }
    public static void main(String[] args) {

        for(Map.Entry entry : twoLevelMappingExample2().entrySet()) {
            System.out.println(entry.getKey() + " :: " + entry.getValue());
        }


    }
}
