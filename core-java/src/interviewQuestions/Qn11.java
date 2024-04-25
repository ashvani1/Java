//Write java Program to Find Smallest and Largest Element in an Array.
package interviewQuestions;

public class Qn11 {
    public static void main(String[] args) {
        int[] array = {10, 20, 5, 30, 15};

        int smallest = array[0];
        int largest = array[0];

        for (int i = 1; i < array.length; i++) {
            if (array[i] < smallest) {
                smallest = array[i];
            }
            if (array[i] > largest) {
                largest = array[i];
            }
        }

        System.out.println("Smallest element in the array: " + smallest);
        System.out.println("Largest element in the array: " + largest);
    }
}
