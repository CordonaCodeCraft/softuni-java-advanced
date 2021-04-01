
// Judge ready

package FunctionalProgramming.Lab;
import java.util.Arrays;
import java.util.Scanner;
import java.util.function.*;

public class _04_AddVAT {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        Function<String, Double> parseToDouble = Double::parseDouble;
        UnaryOperator<Double> calculateVAT = value -> value * 1.2;
        Consumer<Double> printValue = value -> System.out.printf("%.2f%n",value);

        double[] doubles = Arrays
                .stream(s.nextLine().split(", "))
                .map(parseToDouble)
                .map(calculateVAT)
                .mapToDouble(Double::doubleValue)
                .toArray();

        System.out.println("Prices with VAT:");

        Arrays
                .stream(doubles)
                .forEach(printValue::accept);
    }
}
