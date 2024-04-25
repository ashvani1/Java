//Find length of String without using any inbuilt method in java?
package interviewQuestions;

public class Qn10 {
    public static void main(String[] args) {
        String str = "hello";

        int length = 0;
        // Iterate over each character until '\0' [null character] is encountered
        for (char c : str.toCharArray()) {
            if (c == '\0') {
                break; // End of string reached
            }
            length++;
        }

        System.out.println("Length of the string: " + length);
    }
}