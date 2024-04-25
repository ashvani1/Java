package javaconcepts.immutability;

public class ImmutabilityString {
    public static void main(String[] args) {
        // Immutable String
        String immutableString = "immutable";

        // Mutable StringBuilder
        StringBuilder mutableStringBuilder = new StringBuilder("mutable");

        // Print original values
        System.out.println("Original Immutable String: " + immutableString);
        System.out.println("Original Mutable StringBuilder: " + mutableStringBuilder);

        // Modify the String and StringBuilder
        modifyStrings(immutableString, mutableStringBuilder);

        // Print modified values
        System.out.println("Modified Immutable String: " + immutableString);
        System.out.println("Modified Mutable StringBuilder: " + mutableStringBuilder);
    }

    public static void modifyStrings(String str, StringBuilder sb) {
        // Modify the immutable String
        str = str.toUpperCase();

        // Modify the mutable StringBuilder
        sb.append(" modified");
    }
}


/*
immutableString is an immutable String object. When we call toUpperCase() on it, a new String object is created with the
modified value, but the original immutableString remains unchanged. This behavior showcases immutability.
mutableStringBuilder is a mutable StringBuilder object. When we call append() on it, the original StringBuilder instance
is modified directly. This behavior showcases mutability.

The key difference between String and StringBuilder lies in their mutability:
String objects are immutable, meaning their state (i.e., the sequence of characters) cannot be changed after creation.
Any operation that appears to modify a String actually creates a new String object with the modified value.
StringBuilder objects are mutable, meaning their state can be modified after creation.

Operations like append(), insert(), delete(), etc.,modify the contents of the StringBuilder instance directly without
creating new objects.
*/