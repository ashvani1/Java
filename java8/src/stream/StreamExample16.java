package stream;

import functionalInterfaces.data.Student;
import functionalInterfaces.data.Students;

import java.util.*;
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

    /*
    * Student::getName is a classifier function that extracts the name of each student, used for grouping.
      LinkedHashMap::new specifies that the resulting map should be a LinkedHashMap.
Collectors.toSet() specifies that the values in the map should be sets, ensuring that there are no duplicate students for each name.*/


    static Map<String, Set<Student>> twoParamGroupingByExample3() {
        Map<String, Set<Student>> result = studentList.stream()
                .collect(Collectors.groupingBy(Student::getName,    //group the stream by name //we will store it in LinkedHashMap
                        Collectors.toSet()));
        return result;
    }

    public static void main(String[] args) {

        for (Map.Entry entry : threeParamGroupingByExample1().entrySet()) {
            System.out.println(entry.getKey() + " :: " + entry.getValue());
        }
    }
}
