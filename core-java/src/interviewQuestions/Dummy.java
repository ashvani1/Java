package interviewQuestions;

import java.lang.ref.WeakReference;

class Dummy {
    public static void main(String[] args) {

        int intValue = 10;
        String strValue = "10";

        // Parsing the string to an integer
        int parsedInt = Integer.parseInt(strValue);

        // Creating Integer objects from primitive ints
        Integer intValueObj = intValue;
        Integer parsedIntObj = parsedInt;

        // Using equals() method to compare Integer objects
        boolean isEqual = intValueObj.equals(parsedIntObj);
    }
}


