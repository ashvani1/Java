//Find second largest number in an array
package interviewQuestions;

public class Qn15 {
    public static void main(String[] args) {
        int[] arr = {10, 5, 7, 3, 9, 8};
        int secondLargest = findSecondLargest(arr);
        System.out.println("Second largest number in the array: " + secondLargest);
    }

    public static int findSecondLargest(int[] arr) {
        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;

        for (int num : arr) {
            if (num > largest) {
                secondLargest = largest;
                largest = num;
            } else if (num > secondLargest && num != largest) {
                secondLargest = num;
            }
        }

        return secondLargest;
    }
}
