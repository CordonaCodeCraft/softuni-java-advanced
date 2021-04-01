
// Judge ready

package SetsAndMaps.Exercises;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class _04_CountSymbols {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        char[] characters = s.nextLine().toCharArray();
        Map<Character, Integer> charactersMap = generateCharactersMap(characters);

        printProduct(charactersMap);

    }

    private static Map<Character, Integer> generateCharactersMap(char[] characters) {
        Map<Character, Integer> charactersMap = new TreeMap<>();

        for (char character : characters) {
            charactersMap.putIfAbsent(character, 0);
            int counter = charactersMap.get(character) + 1;
            charactersMap.put(character, counter);
        }

        return charactersMap;
    }

    private static void printProduct(Map<Character, Integer> charactersMap) {
        for (Character character : charactersMap.keySet()) {
            int value = charactersMap.get(character);
            System.out.printf("%c: %d time/s%n", character, value);
        }
    }
}
