package stream;

import functionalInterfaces.data.Student;
import functionalInterfaces.data.Students;

import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class StreamExample2 {
    static List<Student> studentList = Students.getAllStudents();

    static List<String> mapExample() {
        return studentList.stream().map(Student::getName).toList();
    }

    static List<String> findAllStudentsUniqueActivities() {
        List<String> allActivities
                = studentList.stream()          //Stream<Student>
                .map(Student::getActivities)    //Stream<List<String>>
                .flatMap(List::stream)          //Stream<String>
                .distinct()
                .collect(Collectors.toList());
        return allActivities;
    }

    static Set<String> findAllStudentsUniqueActivitiesWithSet() {
        Set<String> allActivities
                = studentList.stream()          //Stream<Student>
                .map(Student::getActivities)    //Stream<List<String>>
                .flatMap(List::stream)          //Stream<String>
                .collect(Collectors.toSet());
        return allActivities;
    }
    static Long totalStudentsActivities() {
        return studentList.stream()
                .map(student -> student.getActivities())
                .flatMap(List::stream)
                .distinct()
                .count();
    }
    public static void main(String[] args) {
        //System.out.println(mapExample());
        //System.out.println(findAllStudentsUniqueActivities());
        //System.out.println(totalStudentsActivities());

    }
}
