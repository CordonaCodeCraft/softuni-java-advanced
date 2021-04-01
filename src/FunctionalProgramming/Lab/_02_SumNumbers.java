
// Judge ready

package FunctionalProgramming.Lab;
import java.util.Scanner;
import java.util.function.Function;

public class _02_SumNumbers {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String[] tokens = s.nextLine().split(", ");
        Function<String, Integer> parseStringToInteger = Integer::parseInt;
        int sum = 0;
        for (String token : tokens) {
            sum += parseStringToInteger.apply(token);

        }
        System.out.printf("Count = %d%n", tokens.length);
        System.out.printf("Sum = %d", sum);


    }
}
