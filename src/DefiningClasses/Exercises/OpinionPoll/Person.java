package DefiningClasses.Exercises.OpinionPoll;

public class Person {
    String name;
    int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void printPerson() {
        System.out.printf("%s - %d%n", getName(), getAge());
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}
