
// Judge ready

package iterators_and_comparators.exercises.comparing_objects;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static final List<Person> PERSONS = new ArrayList<>();
    private static final int[] STATS = new int[3];

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        while (true) {
            String input = s.nextLine();
            if (input.equals("END")) {
                break;
            } else {
                String[] tokens = input.split("\\s+");
                Person person = new Person();
                person.setName(tokens[0]);
                person.setAge(Integer.parseInt(tokens[1]));
                person.setTown(tokens[2]);
                PERSONS.add(person);
            }
        }

        STATS[2] = PERSONS.size();

        int targetIndex = Integer.parseInt(s.nextLine()) - 1;

        for (Person person : PERSONS) {
            if (person.compareTo(PERSONS.get(targetIndex)) > 0) {
                STATS[0]++;
            } else {
                STATS[1]++;
            }
        }

        if (STATS[0] == 1) {
            System.out.println("No matches");
        } else {
            String product = Arrays.toString(STATS).replaceAll("[\\[\\],]", "");
            System.out.println(product);
        }
    }
}
