package FunctionalProgramming.Exercises;

import java.util.*;
import java.util.function.BiPredicate;
import java.util.stream.Collectors;

public class _10_PredicateParty {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        List<String> guests = Arrays.stream(s.nextLine().split("\\s+")).collect(Collectors.toList());

        BiPredicate<String, String> filterBy = (name, instruction) -> evaluateFilter(name, instruction);

        while (true) {
            String command = s.nextLine();
            if ("Party!".equals(command)) {
                break;
            } else {
                String[] tokens = command.split("\\s+", 2);
                String action = tokens[0];
                String instruction = tokens[1];

                List<String> buffer = new ArrayList<>(guests);

                buffer
                        .stream()
                        .filter(guest -> filterBy.test(guest, instruction))
                        .forEach(guest -> performAction(guests, guest, action));
            }
        }

        if (guests.isEmpty()) {
            System.out.println("Nobody is going to the party!");
        } else {
            Collections.sort(guests);
            String product = String.join(", ", guests);
            System.out.printf("%s are going to the party!", product);
        }
    }

    private static boolean evaluateFilter(String name, String instruction) {
        String[] tokens = instruction.split("\\s+");
        String criteria = tokens[0];
        String filter = tokens[1];

        if (criteria.equals("StartsWith")) {
            String substring = name.substring(0, filter.length());
            return substring.equals(filter);
        } else if (criteria.equals("EndsWith")) {
            String substring = name.substring(name.length() - filter.length());
            return substring.equals(filter);
        } else {
            return name.length() == Integer.parseInt(filter);
        }
    }

    private static void performAction(List<String> guests, String e, String action) {
        if (action.equals("Remove")) {
            guests.remove(e);
        } else {
            guests.add(e);
        }
    }

}
