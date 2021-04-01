package iterators_and_comparators.exercises.comparing_objects;

public class Person implements Comparable<Person> {
    private String name;
    private int age;
    private String town;

    public Person() {
        this.name = " ";
        this.age = 0;
        this.town = " ";
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }

    public String getTown() {
        return this.town;
    }

    @Override
    public int compareTo(Person other) {
        boolean isEqualPerson =  this.name.compareTo(other.name) == 0 && this.age == other.getAge() && this.town.compareTo(other.getTown()) == 0;
        if (isEqualPerson) {
            return 1;
        } else {
            return 0;
        }
    }
}
