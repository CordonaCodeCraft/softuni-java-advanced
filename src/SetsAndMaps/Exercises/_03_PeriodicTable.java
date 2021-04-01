
// Judge ready

package SetsAndMaps.Exercises;

import java.util.Arrays;
import java.util.Scanner;
import java.util.TreeSet;

public class _03_PeriodicTable {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int linesCount = Integer.parseInt(s.nextLine());
        TreeSet<String> elements = generatePeriodicTable(linesCount, s);

        printElements(elements);

    }

    private static TreeSet<String> generatePeriodicTable(int linesCount, Scanner s) {
        TreeSet<String> elements = new TreeSet<>();

        for (int i = 0; i < linesCount; i++) {
            elements.addAll(Arrays.asList(s.nextLine().split(" ")));
        }

        return elements;
    }

    private static void printElements(TreeSet<String> elements) {
        for (String element : elements) {
            System.out.printf("%s ", element);
        }
    }
}
