//Find missing number in the array.
package interviewQuestions;

import java.util.Arrays;

public class Qn12 {
    public static void main(String[] args) {
        int a[] = {1,2,4};  //only 1 number is missing from 1 to n
        int n = a.length + 1;
        int expectedTotal = (n * (n+1))/2;
        System.out.println("expected "+expectedTotal);
        int currentTotal = Arrays.stream(a).sum();
        System.out.println("current "+currentTotal);
        System.out.println(expectedTotal-currentTotal);

    }
}
