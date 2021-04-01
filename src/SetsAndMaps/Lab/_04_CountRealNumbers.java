
// Judge ready

package SetsAndMaps.Lab;

import java.util.*;

public class _04_CountRealNumbers {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        Map<Double, Integer> realNumbersMap = new LinkedHashMap<>();

        List<Double> realNumbersList = generateRealNumbersList(s);

        populateRealNumbersMap(realNumbersMap, realNumbersList);

        printResult(realNumbersMap);


    }

    private static List<Double> generateRealNumbersList(Scanner s) {
        List<Double> realNumbersList = new ArrayList<>();
        Arrays
                .stream(s.nextLine().split("\\s+"))
                .mapToDouble(Double::parseDouble)
                .forEach(realNumbersList::add);

        return realNumbersList;
    }

    private static void populateRealNumbersMap(Map<Double, Integer> realNumbersMap, List<Double> realNumbersList) {

        for (Double realNumber : realNumbersList) {
            realNumbersMap.putIfAbsent(realNumber, 0);
            int counter = realNumbersMap.get(realNumber) + 1;
            realNumbersMap.put(realNumber, counter);
        }

    }

    private static void printResult(Map<Double, Integer> realNumbersMap) {
        for (Double aDouble : realNumbersMap.keySet()) {
            System.out.printf("%.1f -> %d%n",aDouble, realNumbersMap.get(aDouble) );
        }



    }

}

