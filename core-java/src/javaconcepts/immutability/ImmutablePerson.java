package javaconcepts.immutability;

import java.util.ArrayList;
import java.util.List;

public final class ImmutablePerson {
    private final String name;  //String is immutable
    private final int age;      //primitive fields are immutable
    private final List<String> hobbies; // Mutable field [List], so we will handle it in defensive copy

    public ImmutablePerson(String name, int age, List<String> hobbies) {
        this.name = name;
        this.age = age;
        this.hobbies = new ArrayList<>(hobbies); // Defensive copy
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public List<String> getHobbies() {
        return new ArrayList<>(hobbies); // Defensive copy
    }
}


/*

To create a custom immutable class in Java, you can follow these guidelines:
Declare the class as final to prevent inheritance.
Make all fields private and final to ensure they cannot be modified after initialization.
Provide a constructor to initialize all fields.
Do not provide any setter methods to modify the fields after object creation.
If the class contains mutable fields (e.g., collections), ensure they are defensively copied to maintain immutability.

In the context of immutability and defensive programming, a defensive copy refers to creating a new copy of an object
to prevent modifications to the original object.

In the example provided, defensive copying is employed to ensure that the mutable hobbies field of the ImmutablePerson
class cannot be modified from outside the class. When a client retrieves the list of hobbies using the getHobbies()
method, the method returns a new ArrayList object that contains the same elements as the original hobbies list. This
new list is independent of the original list, and any modifications made to it will not affect the original list
stored in the ImmutablePerson instance.
*/
