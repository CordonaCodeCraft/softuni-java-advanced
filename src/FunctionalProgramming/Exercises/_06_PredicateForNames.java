
// Judge ready

package FunctionalProgramming.Exercises;
import java.util.Arrays;
import java.util.Scanner;
import java.util.function.BiPredicate;

public class _06_PredicateForNames {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        BiPredicate<String, Integer> filter = (name, integer) -> name.length() <= integer;
        int length = Integer.parseInt(s.nextLine());
        Arrays
                .stream(s.nextLine().split("\\s+"))
                .filter(e -> filter.test(e, length))
                .forEach(e -> System.out.printf("%s%n", e));
    }
}
