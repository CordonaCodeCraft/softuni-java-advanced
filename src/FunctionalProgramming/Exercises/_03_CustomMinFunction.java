
// Judge ready

package FunctionalProgramming.Exercises;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Function;

public class _03_CustomMinFunction {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        Function<Integer[], Integer> minimalValue = a -> Arrays
                .stream(a).mapToInt(Integer::intValue)
                .min()
                .getAsInt();

        Integer[] input = Arrays
                .stream(s.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .toArray(Integer[]::new);


        System.out.println(minimalValue.apply(input));
    }
}
