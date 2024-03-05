package stream;

import functionalInterfaces.data.Student;
import functionalInterfaces.data.Students;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

//groupingBY(single param) :: similar to groupBy() in sql
public class StreamExample14 {
    static List<Student> studentList = Students.getAllStudents();

    static Map<Integer, List<Student>> groupStudentByGrade() {
        Map<Integer, List<Student>> groupStudentByGrade
                = studentList.stream()
                .collect(Collectors.groupingBy(student -> student.getGradeLevel()));  //groupingBy() takes a function
        return groupStudentByGrade;
    }

    static Map<String, List<Student>> customizedStudentGroupingByGPA() {
        return studentList.stream().collect(Collectors.groupingBy(student -> student.getGpa() > 3 ? "OUTSTANDING":"AVERAGE"));
    }
    public static void main(String[] args) {
        for(Map.Entry entry : customizedStudentGroupingByGPA().entrySet()) {
            System.out.println(entry.getKey() + " :: " + entry.getValue());
        }

    }
}
