package iterators_and_comparators.exercises.equality_logic;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        Set<Person> personHashSet = new HashSet<>();
        TreeSet<Person> personTreeSet = new TreeSet<>();
        int personsCount = Integer.parseInt(s.nextLine());

        while (--personsCount >= 0) {
            String[] tokens = s.nextLine().split("\\s+");
            Person person = new Person();
            person.setName(tokens[0]);
            person.setAge(Integer.parseInt(tokens[1]));
            personHashSet.add(person);
            personTreeSet.add(person);
        }

        System.out.println(personHashSet.size());
        System.out.println(personTreeSet.size());
    }
}
