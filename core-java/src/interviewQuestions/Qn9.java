//Find all substrings of String in java?
package interviewQuestions;

public class Qn9 {
    public static void main(String[] args) {
        String str = "hello";

        // Iterate over each character in the string
        for (int i = 0; i < str.length(); i++) {
            // Generate substrings starting from the current character
            for (int j = i + 1; j <= str.length(); j++) {
                String substring = str.substring(i, j);
                System.out.println(substring);
            }
        }
    }
}
