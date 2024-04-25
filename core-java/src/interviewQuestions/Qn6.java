//How to check if one String is rotation of another String in java?
package interviewQuestions;

public class Qn6 {
    public static void main(String[] args) {
        String str1 = "waterbottle";
        String str2 = "erbottlewat";

        System.out.println("Is '" + str2 + "' a rotation of '" + str1 + "'? " + isRotation(str1, str2));
    }

    public static boolean isRotation(String str1, String str2) {
        // Check if lengths are equal and not zero
        if (str1.length() == str2.length() && str1.length() > 0) {
            String concatenatedStr = str1 + str1;
            return concatenatedStr.contains(str2);
        }
        return false;
    }
}