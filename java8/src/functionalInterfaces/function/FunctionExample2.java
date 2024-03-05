package functionalInterfaces.function;

import functionalInterfaces.data.Student;
import functionalInterfaces.data.Students;

import java.util.*;
import java.util.function.Function;

import static functionalInterfaces.predicate.PredicateExample2.getStudentsWithGoodGrades;

public class FunctionExample2 {

    //This function is just getting some form or Student, doing some ops and returning back output
    static Function<List<Student>, Map<String, List<String>>> studentWithActivities = (students) -> {
        //first create a map
        Map<String, List<String>> map = new HashMap<>();

        //iterate over the students
        students.forEach(
                student -> {
                    //before putting values to map we can plugin any filters using predicate, for ex
                    if(getStudentsWithGoodGrades.test(student)) {
                        map.put(student.getName(), student.getActivities());
                    }
                }
        );
        return map;
    };

    public static void main(String[] args) {
        Map<String, List<String>> result = studentWithActivities.apply(Students.getAllStudents());
        System.out.println(result);
    }
}

//Function is most important for day to day tasks, it is kind a formula which can be applied on input by passing input through
//apply() method.