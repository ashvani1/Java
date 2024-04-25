//Find first non repeated character in String in java?
package interviewQuestions;
import java.util.*;
public class Qn8 {
    public static void main(String[] args) {
        String str = "hello world";

        char firstNonRepeatedChar = findFirstNonRepeatedChar(str);
        if (firstNonRepeatedChar != '\0') {
            System.out.println("First non-repeated character: " + firstNonRepeatedChar);
        } else {
            System.out.println("No non-repeated character found");
        }
    }

    public static char findFirstNonRepeatedChar(String str) {
        Map<Character, Integer> charFrequency = new LinkedHashMap<>();

        // Count frequency of characters
        for (char ch : str.toCharArray()) {
            charFrequency.put(ch, charFrequency.getOrDefault(ch, 0) + 1);
        }

        // Find first non-repeated character
        for (Map.Entry<Character, Integer> entry : charFrequency.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }

        // If no non-repeated character found, return null character
        return '\0';
    }
}

//In Java, '\0' represents the null character.