package functionalInterfaces.data;
import java.util.*;
import java.util.function.Supplier;

public class Students {
    public static List<Student>getAllStudents() {
        List<Student> students = new ArrayList<>();
        Student student1 = new Student("ashvani", 9, 92,"Male", Arrays.asList("swimming", "cricket", "bowling"), 10);
        Student student8 = new Student("ashvani", 9, 91,"Male", Arrays.asList("swimming", "cricket", "bowling"), 5);
        Student student9 = new Student("ashvani", 9, 91,"Male", Arrays.asList("swimming", "cricket", "bowling", "football"), 5);
        Student student2 = new Student("akshay", 12, 60,"Male", Arrays.asList("gymnastics", "cricket", "football"),12);
        Student student3 = new Student("aayush", 11, 51,"Male", Arrays.asList("swimming", "cricket", "football"),1);
        Student student4 = new Student("aaryan", 12, 100, "Male", Arrays.asList("swimming", "volleyball", "football"),4);
        Student student10 = new Student("aaryan", 12, 101, "Male", Arrays.asList("swimming", "volleyball", "football", "baseball"),2);
        Student student13 = new Student("aaa", 12, 100, "Male", Arrays.asList("swimming", "volleyball", "football", "baseball"),9);
        Student student11 = new Student("aaryan", 12, 100, "Male", Arrays.asList("swimming", "volleyball", "football", "baseball"),6);
        Student student12 = new Student("aaryan", 12, 90, "Male", Arrays.asList("swimming", "volleyball", "football", "baseball", "other", "other"), 4);
        Student student5 = new Student("vishal", 11, 100,"Male", Arrays.asList("swimming", "basketball", "football", "baseball"), 9);
        Student student6 = new Student("mani", 10, 11,"Male", Arrays.asList("swimming", "cricket", "football", ""), 10);
        Student student7 = new Student("ranjit", 10, 90,"Male", Arrays.asList("swimming", "cricket", "baseball"), 12);

        students = Arrays.asList(student1, student2, student3, student4, student5, student6, student7, student8, student9, student10, student11, student12, student13, null);
        return students;
    }

    public static Supplier<Student> studentSupplier = () ->
    {
        return new Student("rohit", 10, 90,"Male", Arrays.asList("swimming", "cricket", "baseball"), 12);
    };
}
