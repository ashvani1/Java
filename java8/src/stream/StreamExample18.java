package stream;


import functionalInterfaces.data.Student;
import functionalInterfaces.data.Students;

import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class StreamExample18 {
    static List<Student> studentList = Students.getAllStudents();

    static Map<Boolean, List<Student>> partitioningBy() {
        Predicate<Student> gpaPredicate = student -> student.getGpa() > 90;
        Map<Boolean, List<Student>> result
                = studentList.stream()
                .collect(Collectors.partitioningBy(gpaPredicate));
        return result;
    }

    public static void main(String[] args) {
        for (Map.Entry entry : partitioningBy().entrySet()) {
            System.out.println(entry.getKey() + " :: " + entry.getValue());
        }

    }
}
