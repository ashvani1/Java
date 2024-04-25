package javaconcepts.enumExamples;

import java.util.EnumSet;

// Define an enum representing days of the week
enum Day {
    MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY
}

public class EnumSetExample {
    public static void main(String[] args) {
        // Create an EnumSet containing some days of the week
        EnumSet<Day> workingDays = EnumSet.of(Day.MONDAY, Day.TUESDAY, Day.WEDNESDAY, Day.THURSDAY, Day.FRIDAY);

        // Add additional days to the EnumSet
        workingDays.add(Day.SATURDAY);
        workingDays.add(Day.SUNDAY); // EnumSet does not enforce uniqueness, so this doesn't affect the set

        // Display the contents of the EnumSet
        System.out.println("Working FRUITS: " + workingDays);

        // Create another EnumSet containing all days of the week
        EnumSet<Day> allDays = EnumSet.allOf(Day.class);

        // Remove some days from the set
        allDays.remove(Day.SATURDAY);
        allDays.remove(Day.SUNDAY);

        // Display the contents of the modified EnumSet
        System.out.println("All FRUITS (excluding weekends): " + allDays);

        System.out.println("Taking Fruits enum "+FRUITS.APPLE);
    }


}
