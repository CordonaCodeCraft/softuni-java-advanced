package SetsAndMaps.Exercises;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class _10_PopulationCounter {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        Map<String, LinkedHashMap<String, Integer>> populationCounter = generatePopulationCounter(s);

        printStatistics(populationCounter);

    }

    private static Map<String, LinkedHashMap<String, Integer>> generatePopulationCounter(Scanner s) {

        Map<String, LinkedHashMap<String, Integer>> populationCounter = new LinkedHashMap<>();

        while (true) {
            String input = s.nextLine();
            if ("report".equals(input)) {
                break;
            } else {
                String[] tokens = input.split("\\|");
                String city = tokens[0];
                String country = tokens[1];
                int population = Integer.parseInt(tokens[2]);
                populationCounter.putIfAbsent(country, new LinkedHashMap<String, Integer>());
                populationCounter.get(country).putIfAbsent(city, population);
            }
        }
        return populationCounter;
    }

    private static void printStatistics(Map<String, LinkedHashMap<String, Integer>> populationCounter) {
        populationCounter
                .entrySet()
                .stream()
                .sorted((leftCountry, rightCountry) -> Long.compare(calculateCountryTotalPopulation(rightCountry), calculateCountryTotalPopulation(leftCountry)))
                .forEach(country -> printCountryStatistics(country));

    }

    private static Long calculateCountryTotalPopulation(Map.Entry<String, LinkedHashMap<String, Integer>> country) {
        long totalPopulation = 0L;

        LinkedHashMap<String, Integer> cities = country.getValue();

        for (String city : cities.keySet()) {
            int cityPopulation = cities.get(city);
            totalPopulation += cityPopulation;
        }

        return totalPopulation;
    }

    private static void printCountryStatistics(Map.Entry<String, LinkedHashMap<String, Integer>> country) {
        String thisCountry = country.getKey();

        long totalPopulation = calculateCountryTotalPopulation(country);

        System.out.printf("%s (total population: %d)%n", thisCountry, totalPopulation);

        LinkedHashMap<String, Integer> cities = country.getValue();

        cities
                .entrySet()
                .stream()
                .sorted((leftCity, rightCity) -> Integer.compare(rightCity.getValue(), leftCity.getValue()))
                .forEach(city -> System.out.printf("=>%s: %d%n", city.getKey(), city.getValue()));
    }
}


