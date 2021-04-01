
// TODO: 12.07.2020 г. Judge not ready 80/100

package SetsAndMaps.Exercises;

import java.util.*;

public class _02_SetsOfElements {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int[] setsLength = generateTokens(s);
        LinkedHashSet<Integer> setA = generateSet(s, setsLength[0]);
        LinkedHashSet<Integer> setB = generateSet(s, setsLength[1]);
        LinkedHashSet<Integer> identicalIntegers = compareSets(setA, setB);

        printResult(identicalIntegers);

    }

    private static int[] generateTokens(Scanner s) {
        return Arrays
                .stream(s.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
    }

    private static LinkedHashSet<Integer> generateSet(Scanner s, int setLength)  {
        LinkedHashSet<Integer> setOfIntegers = new LinkedHashSet<>();

        for (int i = 0; i < setLength; i++) {
            setOfIntegers.add(s.nextInt());
        }

        return setOfIntegers;
    }

    private static LinkedHashSet<Integer> compareSets(LinkedHashSet<Integer> setA, LinkedHashSet<Integer> setB) {

        LinkedHashSet<Integer> identicalIntegers = new LinkedHashSet<>();

        if (setA.size() > setB.size()) {
            for (Integer integer : setA) {
                if (setB.contains(integer)) {
                    identicalIntegers.add(integer);
                }
            }

        } else {
            for (Integer integer : setB) {
                if (setA.contains(integer)) {
                    identicalIntegers.add(integer);
                }
            }
        }

        return identicalIntegers;
    }

    private static void printResult(LinkedHashSet<Integer> identicalIntegers) {
        for (Integer integer : identicalIntegers) {
            System.out.printf("%d ",integer);
        }
    }
}
