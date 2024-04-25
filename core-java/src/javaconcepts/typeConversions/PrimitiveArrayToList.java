package javaconcepts.typeConversions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PrimitiveArrayToList {
    public static void main(String[] args) {
        int [] array1 = {1,2,3,4,5};
        String[] array2 = {"apple", "banana", "orange"};
        List<Integer> arrayList1 = Arrays.stream(array1).boxed().toList();
        List<String> arrayList2 = Arrays.stream(array2).toList();

        List<Integer> ar1 = new ArrayList<>(Arrays.asList(1,2,3,4,5));
        List<String> ar2 = new ArrayList<>(Arrays.asList("Banana", "Apple", "Orange"));
        int [] newArray1 = ar1.stream().mapToInt(Integer::intValue).toArray();
        String[] newArray2 = ar2.toArray(new String[0]);
        //When you pass a String[] array of length 0 to the toArray() method, a new array is created to store the elements of the list.
        //Here's how it works:
        //The toArray() method checks the length of the provided array. If the provided array's length is less than the size of the list (ar2.size()), a new array of the same runtime type (String[]) and the same length as the list is created.
        //The elements of the list are then copied into the new array.
        //If the new array is large enough to hold all the elements, they are copied directly into it. If not, a new array is allocated with the runtime type of the specified array and the size of the list.
        //In this specific case, passing a String[] array of length 0 essentially tells the toArray() method to create a new array with the exact size needed to accommodate all the elements in the list. This ensures that the resulting array is exactly the right size to hold all the elements from the list.
        String[] newArray3 = ar2.toArray(new String[ar2.size()]);
        String[] newArray4 = ar2.stream().toArray(String[]::new);

        for(String s : newArray2) {
            System.out.println(s);
        }
    }
}
