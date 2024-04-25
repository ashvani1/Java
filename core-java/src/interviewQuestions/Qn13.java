//Search an element in rotated and sorted array.
package interviewQuestions;

public class Qn13 {
    public static void main(String[] args) {
        int[] arr = {16, 19, 21, 25, 3, 5, 8, 10};
        int target = 5;

        int index = searchRotatedArray(arr, target);

        if (index != -1) {
            System.out.println("Element " + target + " found at index " + index);
        } else {
            System.out.println("Element " + target + " not found in the array");
        }
    }

    public static int searchRotatedArray(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target) {
                return mid;
            }

            // Check if the left half is sorted
            if (arr[left] <= arr[mid]) {
                if (arr[left] <= target && target < arr[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            // Otherwise, the right half is sorted
            else {
                if (arr[mid] < target && target <= arr[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }

        return -1;
    }
}
