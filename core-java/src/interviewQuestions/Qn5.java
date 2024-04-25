//check if String has all unique characters in java?
package interviewQuestions;

public class Qn5 {
    public static void main(String[] args) {
        String str1 = "abcdefg";
        String str2 = "hello";

        System.out.println("Does '" + str1 + "' have all unique characters? " + hasUniqueCharacters(str1));
        System.out.println("Does '" + str2 + "' have all unique characters? " + hasUniqueCharacters(str2));
    }

    public static boolean hasUniqueCharacters(String str) {
        // Assuming ASCII characters (0-127)
        boolean[] charSet = new boolean[128];

        for (int i = 0; i < str.length(); i++) {
            int charVal = str.charAt(i);
            if (charSet[charVal]) {
                // Character already encountered
                return false;
            }
            charSet[charVal] = true;
        }
        return true;
    }
}
