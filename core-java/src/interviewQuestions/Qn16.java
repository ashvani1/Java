//Find the number occurring odd number of times in an array
package interviewQuestions;

public class Qn16 {
    public static void main(String[] args) {
        int[] arr = {4, 3, 4, 3, 2, 1, 1};
        int oddOccurrence = findOddOccurrence(arr);
        System.out.println("Number occurring odd number of times: " + oddOccurrence);
    }

    public static int findOddOccurrence(int[] arr) {
        int result = 0;

        for (int num : arr) {
            result ^= num;
        }

        return result;
    }
}
