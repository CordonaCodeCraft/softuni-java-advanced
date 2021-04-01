
// Judge ready

package LinearDataStructures.Lab;

import java.util.Scanner;
import java.util.Stack;

public class _06_DecimalToBinaryConverter {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int decimal = Integer.parseInt(s.nextLine());
        Stack<Integer> stack = new Stack<>();
        if (decimal == 0) {
            System.out.print("0");
        } else {
            while (decimal != 0) {
                stack.push(decimal % 2);
                decimal /= 2;
            }
        }
        while (!stack.empty()) {
            System.out.print(stack.pop());
        }
    }
}
