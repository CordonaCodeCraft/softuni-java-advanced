
// Judge ready

package DefiningClasses.Exercises.OpinionPoll;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int peopleCount = Integer.parseInt(s.nextLine());
        List<Person> individuals = new ArrayList<>();

        while (--peopleCount >= 0) {
            String[] tokens = s.nextLine().split("\\s+");
            String name = tokens[0];
            int age = Integer.parseInt(tokens[1]);
            individuals.add(new Person(name, age));
        }

        individuals
                .stream()
                .filter(e -> e.getAge() > 30)
                .sorted(Comparator.comparing(Person::getName))
                .forEach(Person::printPerson);
    }
}
