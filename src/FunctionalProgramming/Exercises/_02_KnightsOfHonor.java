package FunctionalProgramming.Exercises;

// Judge ready

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;

public class _02_KnightsOfHonor {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        Consumer<String> printer = e -> System.out.printf("Sir %s%n", e);
        Arrays
                .stream(s.nextLine().split("\\s+"))
                .forEach(printer);
    }
}
