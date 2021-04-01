package FunctionalProgramming.Exercises;

// Judge ready

import java.util.*;
import java.util.function.Consumer;

public class _01_ConsumerPrint {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        Consumer<String> printer = e -> System.out.printf("%s%n", e);
        Arrays
                .stream(s.nextLine().split("\\s+"))
                .forEach(printer);

    }
}
