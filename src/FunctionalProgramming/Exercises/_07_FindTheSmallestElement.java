
// Judge ready

package FunctionalProgramming.Exercises;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class _07_FindTheSmallestElement {
    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        String input = s.nextLine();

        List<Integer> product = Arrays
                .stream(input.split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        Function<List<Integer>, Integer> findSmallestInteger = e -> e
                .stream()
                .mapToInt(Integer::intValue)
                .min().getAsInt();


        int smallestInteger = findSmallestInteger.apply(product);

        System.out.println(input.lastIndexOf(smallestInteger));

    }
}
