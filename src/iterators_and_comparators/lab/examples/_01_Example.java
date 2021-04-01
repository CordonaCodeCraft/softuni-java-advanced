package iterators_and_comparators.lab.examples;

import java.util.ArrayList;
import java.util.List;

public class _01_Example {
    public static void main(String[] args) {
        List<Person> persons = new ArrayList<>();
        Person firstPerson = new Person("Ivan",55);
        Person secondPerson = new Person("Georgi",55);
        persons.add(firstPerson);
        persons.add(secondPerson);

        persons.stream().sorted().forEach(person -> System.out.printf("%s %d%n", person.getName(),person.getAge()));




    }
}
