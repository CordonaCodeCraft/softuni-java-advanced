
// Judge ready

package SetsAndMaps.Lab;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class _06_ProductShop {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        Map<String, LinkedHashMap<String, Double>> storeCatalogue = generateStoreCatalogue(s);

        printStoreCatalogue(storeCatalogue);
    }

    private static Map<String, LinkedHashMap<String, Double>> generateStoreCatalogue(Scanner s) {
        Map<String, LinkedHashMap<String, Double>> storeCatalogue = new TreeMap<>();

        while (true) {
            String input = s.nextLine();
            if ("Revision".equals(input)) {
                break;
            } else {
                String[] tokens = input.split(", ");
                String store = tokens[0];
                String product = tokens[1];
                double price = Double.parseDouble(tokens[2]);
                storeCatalogue.putIfAbsent(store, new LinkedHashMap<>());
                storeCatalogue.get(store).putIfAbsent(product, price);
            }
        }
        
        return storeCatalogue;
    }

    private static void printStoreCatalogue(Map<String, LinkedHashMap<String, Double>> storeCatalogue) {

        for (String store : storeCatalogue.keySet()) {
            System.out.printf("%s->%n", store);

            for (String product : storeCatalogue.get(store).keySet()) {
                System.out.printf("Product: %s, Price: %.1f%n", product, storeCatalogue.get(store).get(product));
            }

        }
    }
}
