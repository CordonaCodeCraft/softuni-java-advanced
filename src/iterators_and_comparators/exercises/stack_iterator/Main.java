package iterators_and_comparators.exercises.stack_iterator;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        IntegerStack stack = new IntegerStack();
        Scanner s = new Scanner(System.in);

        while (true) {
            String input = s.nextLine();
            String command = extractCommand(input);

            if (input.equals("END")) {
                break;
            } else {
                switch (command) {
                    case "Push":
                        String[] elementsToPush = input.substring(input.indexOf(" ") + 1).trim().split(", ");
                        Arrays
                                .stream(elementsToPush)
                                .map(Integer::parseInt)
                                .forEach(stack::push);
                        break;
                    case "Pop":
                        stack.pop();
                        break;
                }
            }


        }

        stack.forEach(System.out::println);
        stack.forEach(System.out::println);
    }

    private static String extractCommand(String input) {
        if (input.contains(" ")) {
            return input.substring(0, input.indexOf(" "));
        } else {
            return input;
        }
    }
}
