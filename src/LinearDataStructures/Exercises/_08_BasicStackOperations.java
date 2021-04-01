// Judge ready

package LinearDataStructures.Exercises;

import java.util.Scanner;
import java.util.Stack;

public class _08_BasicStackOperations {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String[] parameters = s.nextLine().split("\\s+");
        String[] input = s.nextLine().split("\\s+");
        int pushCount = Integer.parseInt(parameters[0]);
        int popCount = Integer.parseInt(parameters[1]);
        String targetInteger = parameters[2];
        Stack<String> product = new Stack<>();
        populateProduct(input, pushCount, product);
        popProductElements(popCount, product);

        if (product.contains(targetInteger)) {
            System.out.println("true");
        } else if (product.isEmpty()) {
            System.out.println("0");
        } else {
            printSmallestInteger(product);
        }
    }

    private static void populateProduct(String[] input, int pushCount, Stack<String> product) {
        int currentInputIndex = 0;
        while (--pushCount >= 0) {
            String currentElement = input[currentInputIndex];
            product.push(currentElement);
            currentInputIndex++;
        }
    }

    private static void popProductElements(int popCount, Stack<String> product) {
        while (--popCount >= 0) {
            product.pop();
        }
    }

    private static void printSmallestInteger(Stack<String> product) {
        int smallestInteger = Integer.MAX_VALUE;
        while (!product.isEmpty()) {
            int currentInteger = Integer.parseInt(product.pop());
            if (currentInteger < smallestInteger) {
                smallestInteger = currentInteger;
            }
        }
        System.out.println(smallestInteger);
    }
}
