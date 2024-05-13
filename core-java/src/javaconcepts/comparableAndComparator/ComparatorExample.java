package javaconcepts.comparableAndComparator;

import java.util.*;

public class ComparatorExample {
    public static void main(String[] args) {

        NewCountry country2 = new NewCountry(2, "Canada");
        NewCountry country3 = new NewCountry(2, "India");
        NewCountry country1 = new NewCountry(1, "USA");
        NewCountry country4 = new NewCountry(1, "UK");

        List<NewCountry> countryList = new ArrayList<>();
        countryList.add(country1);
        countryList.add(country4);
        countryList.add(country2);
        countryList.add(country3);

        Collections.sort(countryList, new NewCountry());

        System.out.println("sorted list");
        for (NewCountry country : countryList)
        {
            System.out.println(country.getName());
    }


        //below will not work
       /* var map = new TreeMap<>();
        map.put(country1, "country1");
        map.put(country2, "country2");
        map.put(country3, "country3");
        map.put(country4, "country4");

        System.out.println("*****");
        System.out.println(map);
        System.out.println("*****");*/

        var map = new TreeMap<NewCountry, String>(new NewCountry());
        map.put(country1, "country1");
        map.put(country2, "country2");
        map.put(country3, "country3");
        map.put(country4, "country4");

        System.out.println("*****");
        System.out.println(map);
        System.out.println("*****");

    }
}

class NewCountry implements Comparator<NewCountry> {
    public NewCountry()
    {}

    private int NewCountryId;
    private String name;

    public NewCountry(int NewCountryId, String name) {
        this.NewCountryId = NewCountryId;
        this.name = name;
    }

    String getName() {
        return name;
    }

    @Override
    public int compare(NewCountry o1, NewCountry o2) {
        //understanding: compare 2 objects based on their countryId

//        if (o1.NewCountryId < o2.NewCountryId) {
//            return -1;
//        } else if (o1.NewCountryId > o2.NewCountryId) {
//            return 1;
//        } else {
//            return 0;
//        }

        //now there is an advantage, we can implement more complex comparision like, if 2 countyId as same
        if (o1.NewCountryId < o2.NewCountryId) {
            return -1;
        } else if (o1.NewCountryId > o2.NewCountryId) {
            return 1;
        } else { //means 2 country have same id so sort them based on name in desending order
            return - o1.getName().compareTo(o2.getName());
        }
    }
}

//class which is implementing Comparator, cant be added as a key of treemap,
// but if we pass an object of comparator class then it will work