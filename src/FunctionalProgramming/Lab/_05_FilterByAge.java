package FunctionalProgramming.Lab;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Predicate;

public class _05_FilterByAge {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        Map<String, Integer> persons = feedPeopleDatabase(s);
        String[] tokens = generateTokens(s);
        
        Predicate<Integer> ageTressHold = evaluatePredicate(tokens);

        persons
                .entrySet()
                .stream()
                .filter(e -> ageTressHold.test(e.getValue()))
                .forEach(e -> printResult(e, tokens[2]));


    }

    private static void printResult(Map.Entry<String, Integer> e, String token) {
        if (token.equals("name")) {
            System.out.printf("%s%n",e.getKey());
        } else if (token.equals("age")) {
            System.out.printf("%d%n", e.getValue());
        } else {
            System.out.printf("%s - %d%n", e.getKey(),e.getValue());
        }
    }

    private static Map<String, Integer> feedPeopleDatabase(Scanner s) {

        Map<String, Integer> persons = new LinkedHashMap<>();

        int peopleCount = Integer.parseInt(s.nextLine());

        for (int i = 0; i < peopleCount; i++) {
            String[] tokens = s.nextLine().split(", ");
            String name = tokens[0];
            int age = Integer.parseInt(tokens[1]);
            persons.putIfAbsent(name, age);
        }

        return persons;
    }

    private static String[] generateTokens(Scanner s) {
        String[] tokens = new String[3];

        for (int i = 0; i < 3; i++) {
            String line = s.nextLine();
            tokens[i] = line;
        }

        return tokens;
    }

    private static Predicate<Integer> evaluatePredicate(String[] tokens) {
        int tressHold = Integer.parseInt(tokens[1]);
        if (tokens[0].equals("younger")) {
            return n -> n <= tressHold;
        } else {
            return n -> n >= tressHold;
        }
    }

}
