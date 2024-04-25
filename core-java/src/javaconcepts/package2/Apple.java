package javaconcepts.package2;

import javaconcepts.package1.Fruits;

public class Apple extends Fruits {
    @Override
    protected void taste() {
        System.out.println("Apples are sweet");
    }
}
