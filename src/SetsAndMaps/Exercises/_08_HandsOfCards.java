
// Judge ready

package SetsAndMaps.Exercises;

import java.util.*;

public class _08_HandsOfCards {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        Map<String, LinkedHashSet<String>> players = generatePlayers(s);

        calculateTotalValues(players);

        printResult(players);


    }

    private static Map<String, LinkedHashSet<String>> generatePlayers(Scanner s) {

        Map<String, LinkedHashSet<String>> players = new LinkedHashMap<>();

        while (true) {
            String input = s.nextLine();
            if ("JOKER".equals(input)) {
                break;
            } else {
                String[] tokens = input.split(": ");
                String name = tokens[0];
                String[] currentDeck = tokens[1].split(", ");
                players.putIfAbsent(name, new LinkedHashSet<>());
                players.put(name, feedPlayerDeck(players, name, currentDeck));
            }
        }

        return players;
    }

    private static LinkedHashSet<String> feedPlayerDeck(Map<String, LinkedHashSet<String>> players, String name, String[] cards) {
        LinkedHashSet<String> updatedDeck = players.get(name);
        updatedDeck.addAll(Arrays.asList(cards));
        return updatedDeck;
    }

    private static void calculateTotalValues(Map<String, LinkedHashSet<String>> players) {

        for (String player : players.keySet()) {
            Set<String> playerCards = players.get(player);
            int totalValue = 0;
            for (String card : playerCards) {
                totalValue += calculateCardValue(card);
            }
            playerCards.clear();
            players.get(player).add(String.valueOf(totalValue));
        }
    }

    private static int calculateCardValue(String card) {
        String powerType = card.substring(0, card.length() - 1);

        int power = 0;

        try {
            power = Integer.parseInt(powerType);
        } catch (NumberFormatException e) {
            char powerCharacter = powerType.charAt(0);
            switch (powerCharacter) {
                case 'J':
                    power = 11;
                    break;
                case 'Q':
                    power = 12;
                    break;
                case 'K':
                    power = 13;
                    break;
                case 'A':
                    power = 14;
                    break;
            }
        }

        char cardType = card.charAt(card.length() - 1);

        int multiplier = 0;

        switch (cardType) {
            case 'S':
                multiplier = 4;
                break;
            case 'H':
                multiplier = 3;
                break;
            case 'D':
                multiplier = 2;
                break;
            case 'C':
                multiplier = 1;
                break;
        }

        return power * multiplier;
    }

    private static void printResult(Map<String, LinkedHashSet<String>> players)  {

        for (String player : players.keySet()) {
            String totalValue = players.get(player).iterator().next();
            System.out.printf("%s: %s%n", player, totalValue);
        }

    }
}
