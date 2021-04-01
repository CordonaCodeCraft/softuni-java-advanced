package iterators_and_comparators.exercises.equality_logic;

public class Person implements Comparable<Person> {
    private String name;
    private Integer age;

    public Person() {
        this.name = " ";
        this.age = 0;
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
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null || getClass() != other.getClass()) {
            return false;
        }
        Person person = (Person) other;
        return name.equals(person.name) && age.equals(person.age);
    }

    @Override
    public int hashCode() {
        return name.hashCode() * this.age.hashCode();
    }


    @Override
    public int compareTo(Person other) {
        int weight = this.name.compareTo(other.getName());

        if (weight == 0) {
            weight = this.age - other.getAge();
        }
        return weight;
    }
}
