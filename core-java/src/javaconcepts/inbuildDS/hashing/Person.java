package javaconcepts.inbuildDS.hashing;

public class Person {
    private String name;
    private int age;
    private long personId; // New field for PersonId

    // Constructors
    public Person(String name, int age, long personId) {
        this.name = name;
        this.age = age;
        this.personId = personId;
    }

    // Getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public long getPersonId() {
        return personId;
    }

    public void setPersonId(long personId) {
        this.personId = personId;
    }

    @Override
    public int hashCode() {
        int prime = 31;
        int result = 1;
        result = prime * result + age;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + Long.hashCode(personId); // Include personId in hashCode
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        Person other = (Person) obj;
        if (age != other.age)
            return false;
        if (personId != other.personId)
            return false; // Include personId in equals
        if (name == null) {
            return other.name == null;
        } else
            return name.equals(other.name);
    }

    public static void main(String[] args) {
        Person P1 = new Person("Ashvani", 41, 1);
        Person P2 = new Person("Ashvani", 41, 1);
        Person P3 = P2;
        System.out.println(P1.equals(P2));
        System.out.println(P1.equals(P3));
        System.out.println(P3.equals(P2));
    }
}

