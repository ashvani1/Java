package javaconcepts.comparableAndComparator;

import java.util.*;

public class ComparableExample {
    public static void main(String[] args) {

        Country country0 = new Country(20, "A");
        Country country2 = new Country(2, "Canada");
        Country country1 = new Country(1, "USA");
        Country country3 = new Country(5, "USAA");
        Country country4 = new Country(2, "A");

        int result = country1.compareTo(country2);
        System.out.println("Comparison result: " + result);

        int result1 = country2.compareTo(country1);
        System.out.println("Comparison result1: " + result1);

        int result2 = country2.compareTo(country3);
        System.out.println("Comparison result1: " + result2);

        List<Country> countryList = new ArrayList<>();
        countryList.add(country1);
        countryList.add(country2);
        countryList.add(country3);
        countryList.add(country4);
        Collections.sort(countryList);
        System.out.println(countryList);

        var map = new TreeMap<>();
        map.put(country1, "country1");
        map.put(country2, "country2");
        map.put(country3, "country3");
        map.put(country4, "country4");
        map.put(country0, "country0");

        System.out.println("*****");
        System.out.println(map);
        System.out.println("*****");
    }
}

class Country implements Comparable<Country> {
    @Override
    public String toString() {
        return "Country{" +
                "countryId=" + countryId +
                ", name='" + name + '\'' +
                '}';
    }

    private int countryId;
    private String name;

    public Country(int countryId, String name) {
        this.countryId = countryId;
        this.name = name;
    }

    @Override
    public int compareTo(Country country) {
        //return Integer.compare(this.countryId, country.countryId);
        //or

        //understanding: whatever we have already inserted (this), if next one(country) is smaller than this, so it returns -1
        if (this.countryId < country.countryId) {
            return -1;
        } else if (this.countryId > country.countryId) {
            return 1;
        } else {
            return 0;
        }
    }
}


/*
If any class implements comparable interface then collection of that object can be sorted automatically using Collection.sort()
or Arrays.sort().Object will be sort on the basis of compareTo method in that class.
Objects which implement Comparable in java can be used as keys in a SortedMap like TreeMap or SortedSet like TreeSet without
implementing any other interface.*/