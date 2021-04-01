
// Judge ready

package SetsAndMaps.Exercises;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class _13_SrabskoUnleashed {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        Map<String, LinkedHashMap<String, Integer>> singersDataBase = generateSingersDataBase(s);
        printProduct(singersDataBase);


    }

    private static Map<String, LinkedHashMap<String, Integer>> generateSingersDataBase(Scanner s) {
        Map<String, LinkedHashMap<String, Integer>> singersDataBase = new LinkedHashMap<>();

        while (true) {
            String input = s.nextLine();
            if ("End".equals(input)) {
                break;
            } else {
                String[] tokens = validateInputAndExtractTokens(input);
                boolean isValidInput = !tokens[0].equals("x");

                if (isValidInput) {
                    String singer = tokens[0];
                    String venue = tokens[1];
                    int ticketPrice = Integer.parseInt(tokens[2]);
                    int ticketsCount = Integer.parseInt(tokens[3]);

                    int thisRevenue = ticketPrice * ticketsCount;

                    singersDataBase.putIfAbsent(venue, new LinkedHashMap<String, Integer>());

                    if (singersDataBase.get(venue).containsKey(singer)) {
                        int totalRevenue = singersDataBase.get(venue).get(singer);
                        singersDataBase.get(venue).put(singer, thisRevenue + totalRevenue);
                    } else {
                        singersDataBase.get(venue).put(singer, thisRevenue);
                    }
                }
            }
        }

        return singersDataBase;

    }

    private static String[] validateInputAndExtractTokens(String input) {
        String[] tokens = new String[4];
        Pattern inputPattern = Pattern.compile("(?<name>^[a-zA-Z]+?\\s?[a-zA-Z]+\\s?[a-zA-Z]+)\\s(?<venue>@[a-zA-Z]+?\\s?([a-zA-Z]+\\s)?[a-zA-Z]+)\\s(?<ticketPrice>[0-9]+)\\s(?<ticketsCount>[0-9]+)");
        Matcher inputMatcher = inputPattern.matcher(input);

        if (inputMatcher.find()) {
            tokens[0] = inputMatcher.group("name");
            tokens[1] = inputMatcher.group("venue").substring(1);
            tokens[2] = inputMatcher.group("ticketPrice");
            tokens[3] = inputMatcher.group("ticketsCount");
        } else {
            Arrays.fill(tokens, "x");
        }

        return tokens;
    }

    private static void printProduct(Map<String, LinkedHashMap<String, Integer>> singersDataBase)  {

        for (String venue : singersDataBase.keySet()) {
            System.out.printf("%s%n",venue);
            singersDataBase
                    .get(venue)
                    .entrySet()
                    .stream()
                    .sorted((leftSinger, rightSinger) -> Integer.compare(rightSinger.getValue(), leftSinger.getValue()))
                    .forEach(singer -> System.out.printf("#  %s -> %d%n", singer.getKey(), singer.getValue()) );
        }
    }
}
