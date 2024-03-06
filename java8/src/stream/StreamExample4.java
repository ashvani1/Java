package stream;

import functionalInterfaces.data.Student;
import functionalInterfaces.data.Students;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class StreamExample4 {
    static List<Student> students = Students.getAllStudents();
    static int performMultiplication(List<Integer> numbers) {
        /* first argument is initial value of result, then 2nd is BinaryOperator
        a = 1, b = 5 => result 5 is returned. for next time initial value will be 5
        a = 5, b = 2 => 10
        a = 10, b = 4 => 40
        a = 40, b = 3 => 120
        */
        return numbers.stream().reduce(1, (a, b) -> a*b);
    }

    static Optional<Integer> performMultiplicationWithOutInitialValue(List<Integer> number) {
        //we don't need initial value here, it will multiply all elements are return.. returns Optional<T>
        return number.stream().reduce((a, b) -> a*b);
    }

    static Optional<Student> getHighestGPAStudent() {
        return students.stream().reduce(
                (student1, student2) -> {
                    if(student1.getGpa() > student2.getGpa()){
                        return student1;
                    }
                    else {
                        return student2;
                    }
                }
        );
    }




    public static void main(String[] args) {
        List<Integer> input = Arrays.asList(5,2,4,3);
        //System.out.println(performMultiplication(input));

        Optional<Integer> result = performMultiplicationWithOutInitialValue(new ArrayList<>());
        //System.out.println(result.isPresent()); //for empty list it will return false

        //System.out.println(performMultiplicationWithOutInitialValue(input).get());

        System.out.println(getHighestGPAStudent());

    }
}
