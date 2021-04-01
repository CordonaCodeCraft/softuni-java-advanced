package FunctionalProgramming.Exercises;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.BiPredicate;
import java.util.stream.IntStream;

public class _09_ListOfPredicates {
    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        BiPredicate<Integer, Integer[]> matchLength = (integer, array) -> calculateMatchCount(integer, array).equals(array.length);

        StringBuilder product = new StringBuilder();

        int tressHold = Integer.parseInt(s.nextLine());

        Integer[] integers = Arrays
                .stream(s.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .toArray(Integer[]::new);

        IntStream
                .range(1, tressHold + 1)
                .filter(e -> matchLength.test(e, integers))
                .forEach(e -> product.append(String.format("%d ", e)));

        System.out.println(product.toString());
    }

    private static Integer calculateMatchCount(Integer n, Integer[] integers) {
        int count = 0;

        for (int integer : integers) {
            if (n % integer == 0) {
                count++;
            }
        }

        return count;
    }
}
