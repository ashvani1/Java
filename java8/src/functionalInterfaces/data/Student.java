package functionalInterfaces.data;

import java.util.Comparator;
import java.util.List;

public class Student {
    private String name;
    private Integer gradeLevel;
    private double gpa;
    private String gender;
    private List<String> activities;

    public Student() {

    }

    public Integer getNoteBooks() {
        return noteBooks;
    }

    public void setNoteBooks(Integer noteBooks) {
        this.noteBooks = noteBooks;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", gradeLevel=" + gradeLevel +
                ", gpa=" + gpa +
                ", gender='" + gender + '\'' +
                ", activities=" + activities +
                ", noteBooks=" + noteBooks +
                '}';
    }

    public Student(String name, Integer gradeLevel, double gpa, String gender, List<String> activities, Integer noteBooks) {
        this.name = name;
        this.gradeLevel = gradeLevel;
        this.gpa = gpa;
        this.gender = gender;
        this.activities = activities;
        this.noteBooks = noteBooks;
    }

    private Integer noteBooks;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getGradeLevel() {
        return gradeLevel;
    }

    public void setGradeLevel(Integer gradeLevel) {
        this.gradeLevel = gradeLevel;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public List<String> getActivities() {
        return activities;
    }

    public void setActivities(List<String> activities) {
        this.activities = activities;
    }

    /*
Comparator.comparing(Student::getGradeLevel): This sorts students based on their gradeLevel in ascending order.
thenComparingDouble(Student::getGpa): If two students have the same gradeLevel, this then compares them based on their GPA in ascending order.
thenComparing(Student::getName): If both gradeLevel and GPA are the same, it compares students based on their name in lexicographical order (alphabetical order).
thenComparingInt(student -> student.getActivities().size()): If all previous criteria are the same, it compares students based on the number of activities they have in ascending order.
.reversed(): Finally, the entire comparator is reversed, meaning the list will be sorted in descending order based on the specified criteria.*/

    public static Comparator<Student> studentComparator = Comparator
            .comparing(Student::getGradeLevel)
            .thenComparingDouble(Student::getGpa)
            .thenComparing(Student::getName)
            .thenComparingInt(student -> student.getActivities().size())
            .reversed();
}

