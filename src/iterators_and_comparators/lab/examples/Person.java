package iterators_and_comparators.lab.examples;

public class Person implements Comparable<Person> {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public int compareTo(Person other) {
        if (this.age == other.getAge()) {
             return other.getName().compareTo(this.name);
        }
        return Integer.compare(other.getAge(), this.age);
    }
}
