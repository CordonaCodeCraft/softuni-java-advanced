// Judge ready

package FunctionalProgramming.Lab;

import java.util.*;
import java.util.stream.Collectors;

public class _01_SortEvenNumbers {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        List<Integer> evenIntegers = Arrays
                .stream(s.nextLine().split(", "))
                .map(Integer::parseInt)
                .filter(i -> i % 2 == 0)
                .collect(Collectors.toList());

        String product = evenIntegers.toString().replaceAll("[\\[\\]]", "");
        System.out.println(product);
        Collections.sort(evenIntegers);
        product = evenIntegers.toString().replaceAll("[\\[\\]]", "");
        System.out.println(product);

    }
}
