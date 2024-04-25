//elements present in first list and not in second
package interviewQuestions;

import java.util.Arrays;
import java.util.List;

public class Qn2 {
    public static void main(String[] args) {
        List<Integer> l1 = Arrays.asList(1,23,4,5,5,6);
        List<Integer> l2 = Arrays.asList(1,2,41,53,51,6);

        List<Integer> result = l1.stream().filter(
                a -> !l2.contains(a)
        ).toList();

        for(Integer a : result) {
            System.out.println(a);
        }
    }
}
