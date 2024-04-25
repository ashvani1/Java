package interviewQuestions;
//How to find duplicate characters in String in java?
import java.util.HashMap;
import java.util.Map;
public class Qn7 {
    public static void main(String[] args) {
        String str = "hello world";

        Map<Character, Integer> charFrequency = new HashMap<>();

        // Count frequency of characters
        for (char ch : str.toCharArray()) {
            charFrequency.put(ch, charFrequency.getOrDefault(ch, 0) + 1);

//            if (charFrequency.containsKey(ch)) {
//                charFrequency.put(ch, charFrequency.get(ch) + 1);
//            } else {
//                charFrequency.put(ch, 1);
//            }
        }

        // Print duplicate characters
        System.out.println("Duplicate characters in '" + str + "':");
        for (Map.Entry<Character, Integer> entry : charFrequency.entrySet()) {
            if (entry.getValue() > 1) {
                System.out.println(entry.getKey() + ": " + entry.getValue() + " times");
            }
        }
    }
}
