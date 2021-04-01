
// Judge ready

package FunctionalProgramming.Exercises;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.function.BiPredicate;
import java.util.stream.Collectors;

public class _05_ReverseAndExclude {
    public static void main(String[] args) {

        BiPredicate<Integer, Integer> filter = (x, y) -> x % y != 0;
        
        Scanner s = new Scanner(System.in);

        List<Integer> input = Arrays
                .stream(s.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        int integer = Integer.parseInt(s.nextLine());
        
        Collections.reverse(input);

        input
                .stream()
                .filter(e -> filter.test(e,integer))
                .forEach(e -> System.out.printf("%d ", e));
    }
}
