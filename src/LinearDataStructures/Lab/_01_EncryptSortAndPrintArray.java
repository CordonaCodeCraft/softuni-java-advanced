
// Judge ready

package LinearDataStructures.Lab;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class _01_EncryptSortAndPrintArray {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int iterationsCount = Integer.parseInt(s.nextLine());
        List<Integer> product = new ArrayList<>();

        for (int i = 0; i < iterationsCount; i++) {
            String input = s.nextLine();
            int length = input.length();
            int currentCode = input
                    .chars()
                    .map(e -> calculateCode(e, length))
                    .sum();

            product.add(currentCode);
        }

        Collections.sort(product);
        printProduct(product);
    }

    private static int calculateCode(int e, int length) {
        int characterCode = e;
        char currentLetter = Character.toLowerCase((char) e);
        boolean isVowel = confirmVowel(currentLetter);

        if (isVowel) {
            characterCode *= length;
        } else {
            characterCode /= length;
        }

        return characterCode;
    }

    private static boolean confirmVowel(char currentLetter) {
        return currentLetter == 'a'
                || currentLetter == 'e'
                || currentLetter == 'i'
                || currentLetter == 'o'
                || currentLetter == 'u';
    }

    private static void printProduct(List<Integer> product) {
        for (Integer integer : product) {
            System.out.println(integer);

        }
    }
}
