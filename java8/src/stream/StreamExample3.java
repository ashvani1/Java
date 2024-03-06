package stream;

import functionalInterfaces.data.Student;
import functionalInterfaces.data.Students;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

//focused on Sorted techniques in Stream
public class StreamExample3 {
        /*
Comparator.comparing(Student::getGradeLevel): This sorts students based on their gradeLevel in ascending order.
thenComparingDouble(Student::getGpa): If two students have the same gradeLevel, then compares them based on their GPA in ascending order.
thenComparing(Student::getName): If both gradeLevel and GPA are the same, it compares students based on their name in lexicographical order (alphabetical order).
thenComparingInt(student -> student.getActivities().size()): If all previous criteria are the same, it compares students based on the number of activities they have in ascending order.
.reversed(): Finally, the entire comparator is reversed, meaning the list will be sorted in descending order based on the specified criteria.*/

    public static Comparator<Student> studentComparator = Comparator
            .comparing(Student::getGradeLevel)
            .thenComparingDouble(Student::getGpa)
            .thenComparing(Student::getName)
            .thenComparingInt(student -> student.getActivities().size())
            .reversed();
    static List<Student> studentList = Students.getAllStudents();

    static List<Student> studentsSortedByName() {
        return studentList.stream()
                .sorted(Comparator.comparing(Student::getName))                           //sorted() looks for Comparator
                .collect(Collectors.toList());
    }
    public static void main(String[] args) {
        //System.out.println("Students sorted by name");
        //studentsSortedByName().forEach(System.out::println);
        //good example of sorting: must
        studentList.stream().sorted(studentComparator).forEach(System.out::println);

    }
}
