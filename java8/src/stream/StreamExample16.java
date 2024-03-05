package stream;

import functionalInterfaces.data.Student;
import functionalInterfaces.data.Students;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

//groupingBY(three param)
public class StreamExample16 {
    static List<Student> studentList = Students.getAllStudents();
    static LinkedHashMap<String, Set<Student>> threeParamGroupingByExample1() {
        LinkedHashMap<String, Set<Student>> groupedStudents =
                studentList.stream()
                .collect(Collectors.groupingBy(Student::getName,    //group the stream by name
                        LinkedHashMap::new,                         //we will store it in LinkedHashMap
                        Collectors.toSet()));                       //There should not be any duplicate

        return groupedStudents;
    }

    public static void main(String[] args) {

        for (Map.Entry entry : threeParamGroupingByExample1().entrySet()) {
            System.out.println(entry.getKey() + " :: " + entry.getValue());
        }
    }
}
