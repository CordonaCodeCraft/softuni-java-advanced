package LinearDataStructures.Exercises;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class _07_ReverseNumbersWithStack {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        Stack<String> reversedInput = new Stack<>();
        String[] input = s.nextLine().split("\\s+");
        Arrays.stream(input)
                .forEach(reversedInput::push);
        while (!reversedInput.isEmpty()) {
            System.out.printf("%s ", reversedInput.pop());
        }
    }
}
