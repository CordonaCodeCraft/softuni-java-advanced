// Judge ready

package SetsAndMaps.Exercises;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class _06_AMinerTask {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        Map<String, Integer> minedMaterials = generateMinedMaterialsLog(s);

        printMinedMaterials(minedMaterials);

    }

    private static Map<String, Integer> generateMinedMaterialsLog(Scanner s) {
        Map<String, Integer> minedMaterials = new LinkedHashMap<>();

        String material = "";

        while (true) {
            String input = s.nextLine();
            if ("stop".equals(input)) {
                break;
            } else {
                try {
                    int currentQuantity = Integer.parseInt(input);
                    int totalQuantity = minedMaterials.get(material) + currentQuantity;
                    minedMaterials.put(material, totalQuantity);
                } catch (NumberFormatException e) {
                    material = input;
                    minedMaterials.putIfAbsent(material, 0);
                }
            }
        }

        return minedMaterials;
    }

    private static void printMinedMaterials(Map<String, Integer> minedMaterials) {

        for (String material : minedMaterials.keySet()) {
            int minedQuantity = minedMaterials.get(material);
            System.out.printf("%s -> %d%n", material, minedQuantity);
        }

    }
}
