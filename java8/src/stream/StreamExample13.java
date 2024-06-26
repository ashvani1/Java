package stream;

import functionalInterfaces.data.Student;
import functionalInterfaces.data.Students;

import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StreamExample13 {
    static List<Student> studentList = Students.getAllStudents();

    public static int sum() {
        return studentList.stream()
                .collect(Collectors.summingInt(Student::getNoteBooks));
    }

    public static Double average() {
        return studentList.stream()
                .collect(Collectors.averagingInt(Student::getNoteBooks));
    }
    public static void main(String[] args) {
        System.out.println(sum());
        System.out.println(average());


        int sumOfNoteBooks = studentList.stream().mapToInt(student -> student.getNoteBooks()).sum();
        int sumOfNoteBooks1 = studentList.stream().mapToInt(Student::getNoteBooks).sum();
        OptionalDouble averageOfNoteBooks = studentList.stream().mapToInt(student -> student.getNoteBooks()).average();
        System.out.println(sumOfNoteBooks);
        averageOfNoteBooks.ifPresent(System.out :: println);

        //IntStream has a sum() method but Stream doesn't have
    }
}
