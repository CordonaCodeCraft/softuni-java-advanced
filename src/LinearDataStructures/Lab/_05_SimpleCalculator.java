// Judge ready

package LinearDataStructures.Lab;

import java.util.Scanner;
import java.util.Stack;

public class _05_SimpleCalculator {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String[] input = s.nextLine().split("\\s+");
        Stack<String> stack = new Stack<>();
        for (int i = input.length - 1; i >= 0; i--) {
            stack.push(input[i]);
        }
        while (stack.size() > 1) {
            int firstDigit = Integer.parseInt(stack.pop());
            String operand = stack.pop();
            int secondDigit = Integer.parseInt(stack.pop());
            int product = 0;
            if (operand.equals("+")) {
                product = firstDigit + secondDigit;
            } else {
                product = firstDigit - secondDigit;
            }
            stack.push(String.valueOf(product));
        }
        System.out.println(stack.peek());
    }
}

