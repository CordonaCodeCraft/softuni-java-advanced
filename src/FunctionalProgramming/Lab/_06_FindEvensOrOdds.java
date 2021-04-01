
// Judge ready

package FunctionalProgramming.Lab;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;

public class _06_FindEvensOrOdds {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        List<Integer> integers = generateIntegers(s);
        Predicate<Integer> filter = evaluateFilterType(s);

        integers
                .stream()
                .filter(filter)
                .forEach(e -> System.out.printf("%d ", e));

    }

    private static List<Integer> generateIntegers(Scanner s) {
        List<Integer> integers = new ArrayList<>();
        int[] tokens = Arrays.stream(s.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int lowerBound = tokens[0];
        int upperBound = tokens[1];

        for (int i = lowerBound; i <= upperBound; i++) {
            integers.add(i);
        }
        return integers;
    }

    private static Predicate<Integer> evaluateFilterType(Scanner s) {
        String filterType = s.nextLine();

        if (filterType.equals("even")) {
            return n -> n % 2 == 0;
        } else {
            return n -> n % 2 != 0;
        }

    }
}
