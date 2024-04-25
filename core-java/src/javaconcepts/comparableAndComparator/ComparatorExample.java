package javaconcepts.comparableAndComparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

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
        for (NewCountry country : countryList)
        {
            System.out.println(country.getName());
    }

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