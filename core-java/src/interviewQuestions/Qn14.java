//Find minimum element in a sorted and rotated array.
package interviewQuestions;
public class Qn14 {
    public static void main(String[] args) {
    int[] arr = {5, 6, 7, 8, 9, 10, 1, 2, 3};
    int min = findMinimum(arr);
        System.out.println("Minimum element in the rotated array: " + min);
}

    public static int findMinimum(int[] arr) {
        int left = 0;
        int right = arr.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            // If arr[mid] is greater than the last element, search in the right half, because right array is not sorted
            //so there will be minimum element somewhere there
            if (arr[mid] > arr[right]) {
                left = mid + 1;
            }
            // If arr[mid] is less than or equal to the last element, search in the left half
            else {
                right = mid;
            }
        }

        // At the end of the loop, left will point to the minimum element
        return arr[left];
    }
}