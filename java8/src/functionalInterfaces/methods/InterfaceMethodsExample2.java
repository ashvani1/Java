package functionalInterfaces.methods;

import functionalInterfaces.data.Student;
import functionalInterfaces.data.Students;

import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

public class InterfaceMethodsExample2 {

    static Consumer<Student> studentConsumer = student -> System.out.println(student);
    //create functionality and assign to a variable
    static Comparator<Student> nameComparator = Comparator.comparing(Student::getName);
    static Comparator<Student> gpaComparator = Comparator.comparingDouble(Student::getGpa);

    static void sortByName(List<Student> studentList) {
        studentList.sort(nameComparator);
    }

    static void sortByGpaAndName(List<Student> studentList) {
        studentList.sort(gpaComparator.thenComparing(nameComparator));
    }

    static void sortWithNullValues(List<Student> studentList) {
        Comparator<Student> studentComparator = Comparator.nullsFirst(nameComparator);
        //if there is any null value in input list, it will take it as first element.. similarly nullsLast() last element
        studentList.sort(studentComparator);
    }
    public static void main(String[] args) {
        List<Student> studentList = Students.getAllStudents();
        studentList.forEach(studentConsumer);
        //sortByGpaAndName(studentList);
        System.out.println("***************************");
        //studentList.forEach(studentConsumer);
        sortWithNullValues(studentList);
        studentList.forEach(studentConsumer);

    }

}
