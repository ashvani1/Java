package javaconcepts.package1;

public class Orange extends Fruits {
    @Override
    void origin() {
        System.out.println("India:Bijnor");
    }

    public static void main(String[] args) {
        Fruits orange = new Orange();
        orange.origin();

        Fruits fruits = new Fruits();
        fruits.origin();
    }
}
