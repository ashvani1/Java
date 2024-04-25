//Write a java program to check if two Strings are anagram in java?
package interviewQuestions;
import java.util.HashMap;
import java.util.Map;

public class Qn4 {
    public static void main(String[] args) {
        String S1 = "SILENT";
        String S2 = "LISTEN";

        boolean isAnagram = checkAnagram(S1, S2);
        if (isAnagram) {
            System.out.println(S1 + " and " + S2 + " are anagrams.");
        } else {
            System.out.println(S1 + " and " + S2 + " are not anagrams.");
        }
    }

    public static boolean checkAnagram(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false; // Anagrams must have the same length
        }

        // Count the frequency of characters in first string
        Map<Character, Integer> charCount = new HashMap<>();
        for (char c : s1.toCharArray()) {
            charCount.put(c, charCount.getOrDefault(c, 0) + 1);
        }

        // Check if characters in second string match the counts in the map
        for (char c : s2.toCharArray()) {
            if (!charCount.containsKey(c)) {
                return false; // Character not found in first string
            }
            int count = charCount.get(c);
            if (count == 1) {
                charCount.remove(c); // Remove character if count becomes zero
            } else {
                charCount.put(c, count - 1); // Decrement count
            }
        }

        // If map is empty, all characters in first string are matched
        return charCount.isEmpty();
    }
}

