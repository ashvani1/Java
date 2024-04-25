package stream;

import functionalInterfaces.data.Student;
import functionalInterfaces.data.Students;

import java.util.List;

//stream filter map reduce
public class StreamExample5 {
    static List<Student> studentList = Students.getAllStudents();

    static int numberOfNoteBooks() {
        return studentList.stream()                 //Stream<Student>
                .map(Student::getNoteBooks)         //Stream<Integer>
                .reduce(0, Integer::sum);   //reduce Stream to single digit [similar to .reduce(0, (a,b)-> a+b)]
    }


    static int numberOfNoteBooksFromGrade10() {
        return studentList.stream()
                .filter(student -> student.getGradeLevel() == 10)
                .map(Student::getNoteBooks)
                .reduce(0, Integer::sum);
    }
    public static void main(String[] args) {
        System.out.println(numberOfNoteBooksFromGrade10());

    }
}
