
// TODO: 01.08.2020 г. Judge not ready 60 / 100

package FunctionalProgramming.Exercises;
import java.util.Arrays;
import java.util.Scanner;

public class _08_CustomComparator {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        Arrays
                .stream(s.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .sorted((first, second) -> first % 2 == 0 && second % 2 != 0 ? Long.compare(evaluate(second), evaluate(first)) : Long.compare(first, second))
                .forEach(e -> System.out.printf("%d ", e));
    }

    private static long evaluate(long integer) {
        if (integer % 2 == 0) {
            return integer = 1;
        } else {
            return integer = 0;
        }
    }
}