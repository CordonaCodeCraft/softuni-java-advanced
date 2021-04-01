
// Judge ready

package SetsAndMaps.Exercises;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class _14_DragonArmy {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int dragonsCount = Integer.parseInt(s.nextLine());

        Map<String, TreeMap<String, Integer[]>> dragonsStatistics = generateDragonsStatistics(dragonsCount, s);

        printProduct(dragonsStatistics);

    }

    private static Map<String, TreeMap<String, Integer[]>> generateDragonsStatistics(int dragonsCount, Scanner s) {
        Map<String, TreeMap<String, Integer[]>> dragonsStatistics = new LinkedHashMap<>();

        for (int i = 0; i < dragonsCount; i++) {

            String[] tokens = extractTokens(s.nextLine());

            String type = tokens[0];
            String name = tokens[1];
            int damage = Integer.parseInt(tokens[2]);
            int health = Integer.parseInt(tokens[3]);
            int armor = Integer.parseInt(tokens[4]);

            dragonsStatistics.putIfAbsent(type, new TreeMap<>());
            Integer[] statistics = {damage, health, armor};
            dragonsStatistics.get(type).put(name, statistics);
        }

        return dragonsStatistics;
    }

    private static String[] extractTokens(String nextLine) {
        String[] tokens = nextLine.split(" ");

        if (tokens[2].equals("null")) {
            tokens[2] = "45";
        }

        if (tokens[3].equals("null")) {
            tokens[3] = "250";
        }

        if (tokens[4].equals("null")) {
            tokens[4] = "10";
        }

        return tokens;
    }

    private static double[] calculateAverageStatistics(Map<String, TreeMap<String, Integer[]>> dragonsStatistics, String type) {
        double[] averageStatistics = new double[3];

        for (int index = 0; index < averageStatistics.length; index++) {
            int thisIndex = index;
            averageStatistics[thisIndex] = dragonsStatistics
                    .get(type)
                    .values()
                    .stream()
                    .mapToInt(e -> e[thisIndex])
                    .average()
                    .getAsDouble();
        }

        return averageStatistics;
    }

    private static void printProduct(Map<String, TreeMap<String, Integer[]>> dragonsStatistics) {

        for (String type : dragonsStatistics.keySet()) {
            double[] averageStatistics = calculateAverageStatistics(dragonsStatistics, type);
            double averageDamage = averageStatistics[0];
            double averageHealth = averageStatistics[1];
            double averageArmor = averageStatistics[2];

            System.out.printf("%s::(%.2f/%.2f/%.2f)%n", type, averageDamage, averageHealth, averageArmor);

            dragonsStatistics.get(type)
                    .entrySet()
                    .forEach(dragon -> printDragonStatistics(dragon));
        }

    }

    private static void printDragonStatistics(Map.Entry<String, Integer[]> dragon) {
        String name = dragon.getKey();
        int damage = dragon.getValue()[0];
        int health = dragon.getValue()[1];
        int armor = dragon.getValue()[2];
        System.out.printf("-%s -> damage: %d, health: %d, armor: %d%n", name, damage, health, armor);

    }


}
