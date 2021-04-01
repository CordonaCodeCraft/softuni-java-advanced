
// Judge ready

package LinearDataStructures.Lab;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class _02_SplitByWordCasing {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String[] input = s.nextLine().split("[,;:.!()\"'/\\\\\\[\\]\\s]+");
        List<String> lowerCaseWords = new ArrayList<>();
        List<String> upperCaseWords = new ArrayList<>();
        List<String> mixedCaseWords = new ArrayList<>();

        for (String word : input) {
            if (word.length() == 0)  {
                continue;
            }

            int[] typesCount = countTypes(word);
            int lowerCaseCount = typesCount[0];
            int upperCaseCount = typesCount[1];
            int nonLettersCount = typesCount[2];
            boolean isLowerCaseWord = upperCaseCount == 0 && nonLettersCount == 0;
            boolean isUpperCaseWord = lowerCaseCount == 0 && nonLettersCount == 0;
            boolean isMixedCaseWord = upperCaseCount != 0 && lowerCaseCount != 0 || nonLettersCount != 0;

            if (isLowerCaseWord) {
                lowerCaseWords.add(word);
            } else if (isUpperCaseWord) {
                upperCaseWords.add(word);
            } else if (isMixedCaseWord) {
                mixedCaseWords.add(word);
            }
        }

        System.out.printf("Lower-case: %s%n", String.join(", ", lowerCaseWords));
        System.out.printf("Mixed-case: %s%n", String.join(", ", mixedCaseWords));
        System.out.printf("Upper-case: %s%n", String.join(", ", upperCaseWords));

    }

    private static int[] countTypes(String word) {
        int[] typesCount = new int[3];

        for (char character : word.toCharArray()) {
            if (Character.isLowerCase(character)) {
                typesCount[0]++;
            } else if (Character.isUpperCase(character)) {
                typesCount[1]++;
            } else {
                typesCount[2]++;
            }
            if (typesCount[0] != 0 && typesCount[1] != 0 || typesCount[2] != 0) {
                break;
            }
        }

        return typesCount;
    }
}
