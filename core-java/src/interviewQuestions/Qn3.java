//reverse a String
package interviewQuestions;

public class Qn3 {
    public static void main(String[] args) {
        String S = "ashvani";
        StringBuilder SB = new StringBuilder(S);
        System.out.println(SB.reverse());

        int start = 0;
        int end = S.length() - 1;
        char[] charAr = S.toCharArray();

        while(start < end) {
            char temp = S.charAt(start);
            charAr[start] = charAr[end];
            charAr[end] = temp;
            start++;
            end--;
        }
        String result = new String(charAr);
        System.out.println(result);
    }
}
