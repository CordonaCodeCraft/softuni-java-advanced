package FunctionalProgramming.Lab;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class _03_CountUppercaseWords {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        Predicate<String> isUpperCaseWord = string -> Character.isUpperCase(string.charAt(0));

        Deque<String> upperCaseWords = Arrays
                .stream(s.nextLine().split("\\s+"))
                .filter(isUpperCaseWord)
                .collect(Collectors.toCollection(ArrayDeque::new));
        
        System.out.println(upperCaseWords.size());

        while (!upperCaseWords.isEmpty()) {
            System.out.println(upperCaseWords.poll());
        }

        

        


        
    }
}
