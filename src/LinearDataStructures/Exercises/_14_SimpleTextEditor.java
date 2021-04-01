// Judge ready

package LinearDataStructures.Exercises;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class _14_SimpleTextEditor {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        Deque<String> savedProducts = new ArrayDeque<>();
        StringBuilder product = new StringBuilder();
        savedProducts.push(product.toString());
        int commandsCount = Integer.parseInt(s.nextLine());
        while (--commandsCount >= 0) {
            String[] tokens = s.nextLine().split("\\s+");
            String command = findCommandType(tokens);
            switch (command) {
                case "Append":
                    product.append(tokens[1]);
                    savedProducts.push(product.toString());
                    break;
                case "Erase":
                    eraseSymbols(tokens[1], product);
                    savedProducts.push(product.toString());
                    break;
                case "Print Element":
                    printElementAtGivenPosition(tokens[1], product);
                    break;
                case "Undo":
                    savedProducts.pop();
                    product.setLength(0);
                    product.append(savedProducts.peek());
            }
        }
    }

    private static String findCommandType(String[] tokens) {
        switch (tokens[0]) {
            case "1":
                return "Append";
            case "2":
                return "Erase";
            case "3":
                return "Print Element";
            case "4":
                return "Undo";
            default:
                return "x";
        }
    }

    private static void eraseSymbols(String token, StringBuilder product) {
        int eraseCount = Integer.parseInt(token);
        String reducedProduct = product
                .toString()
                .substring(0, product.length() - eraseCount);
        product.setLength(0);
        product.append(reducedProduct);
    }

    private static void printElementAtGivenPosition(String token, StringBuilder product) {
        int targetIndex = Integer.parseInt(token);
        char character = product.charAt(targetIndex - 1);
        System.out.println(character);
    }
}