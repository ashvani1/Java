package optional;

import functionalInterfaces.data.Student;
import functionalInterfaces.data.Students;

import java.util.List;
import java.util.Optional;

// Optional.of()
public class OptionalExample1 {
    static List<Student> students = Students.getAllStudents();
    static String getStudentName() {
        Student student = students.get(0);
        if(student != null){
            return student.getName();
        }
        return null;
    }

    static Optional<Student> getStudentNameWithOptional() {
        //Optional<Student> studentOptional = Optional.ofNullable(students.get(0));
        Optional<Student> studentOptional = Optional.ofNullable(null);  //return Optional.empty()
        if(studentOptional.isPresent()) {
            return studentOptional;
        }
        else {
            return Optional.empty();
        }
    }
    public static void main(String[] args) {
        String name = getStudentName();
        System.out.println(name.length());
        System.out.println(getStudentNameWithOptional().map(Student::getName));

    }
}
