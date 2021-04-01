package iterators_and_comparators.exercises.strategy_pattern;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        Set<Person> personSet1 = new TreeSet<>(new CompareByName());
        Set<Person> personSet2 = new TreeSet<>(new CompareByAge());
        Scanner s = new Scanner(System.in);
        int personsCount = Integer.parseInt(s.nextLine());

        while (--personsCount >= 0) {
            String[] tokens = s.nextLine().split("\\s+");
            Person person = new Person();
            person.setName(tokens[0]);
            person.setAge(Integer.parseInt(tokens[1]));
            personSet1.add(person);
            personSet2.add(person);
        }
        
        personSet1.forEach(person -> System.out.printf("%s %d%n", person.getName(),person.getAge()));
        personSet2.forEach(person -> System.out.printf("%s %d%n", person.getName(),person.getAge()));


    }
}
