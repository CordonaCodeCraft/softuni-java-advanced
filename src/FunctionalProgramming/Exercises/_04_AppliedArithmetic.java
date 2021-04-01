
// TODO: 31.07.2020 г. Judge not ready 80/100

package FunctionalProgramming.Exercises;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Function;

public class _04_AppliedArithmetic {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        StringBuilder product = new StringBuilder();

        int[] input = Arrays
                .stream(s.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        while (true) {
            String instruction = s.nextLine();
            if (instruction.equals("end")) {
                break;
            } else {
                if (instruction.equals("print")) {
                    Arrays
                            .stream(input)
                            .forEach(e -> product.append(String.format("%d ", e)));
                } else {
                    Function<Integer, Integer> arithmeticalAction = evaluateActionType(instruction);
                    int[] result = Arrays
                            .stream(input)
                            .map(arithmeticalAction::apply)
                            .toArray();
                    input = result.clone();
                }
            }
        }

        System.out.println(product.toString());
    }
    private static Function<Integer, Integer> evaluateActionType(String instruction) {
        if (instruction.equals("add")) {
            return n -> n += 1;
        } else if (instruction.equals("multiply")) {
            return n -> n *= 2;
        } else {
            return n -> n -= 1;
        }
    }
}
