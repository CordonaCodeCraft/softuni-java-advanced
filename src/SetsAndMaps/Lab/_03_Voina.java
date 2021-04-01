
// Judge ready

package SetsAndMaps.Lab;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class _03_Voina {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        Set<Integer> firstPlayerDeck = feedPlayerDeck(s);
        Set<Integer> secondPlayerDeck = feedPlayerDeck(s);

        for (int i = 0; i < 50; i++) {
            int firstPlayerCard = firstPlayerDeck.iterator().next();
            firstPlayerDeck.remove(firstPlayerCard);
            int secondPlayerCard = secondPlayerDeck.iterator().next();
            secondPlayerDeck.remove(secondPlayerCard);

            if (firstPlayerCard > secondPlayerCard) {
                firstPlayerDeck.add(firstPlayerCard);
                firstPlayerDeck.add(secondPlayerCard);
                if (secondPlayerDeck.isEmpty()) {
                    break;
                }
            } else if (secondPlayerCard > firstPlayerCard) {
                secondPlayerDeck.add(firstPlayerCard);
                secondPlayerDeck.add(secondPlayerCard);
                if (firstPlayerDeck.isEmpty()) {
                    break;
                }
            }
        }

        if (firstPlayerDeck.size() > secondPlayerDeck.size()) {
            System.out.println("First player win!");
        } else if (secondPlayerDeck.size() > firstPlayerDeck.size()) {
            System.out.println("Second player win!");
        } else  {
            System.out.println("Draw!");
        }
    }

    private static Set<Integer> feedPlayerDeck(Scanner s) {
        Set<Integer> playerDeck = new LinkedHashSet<>();

        Arrays
                .stream(s.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .limit(20)
                .forEach(playerDeck::add);

        return playerDeck;
    }
}
