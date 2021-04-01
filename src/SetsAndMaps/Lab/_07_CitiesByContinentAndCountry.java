
// Judge ready

package SetsAndMaps.Lab;

import java.util.*;

public class _07_CitiesByContinentAndCountry {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int inputCount = Integer.parseInt(s.nextLine());
        
        Map<String, LinkedHashMap<String, List<String>>> countriesDataBase = generateCountriesDataBase(s, inputCount);

        printCountriesDataBase(countriesDataBase);

    }

    private static Map<String, LinkedHashMap<String, List<String>>> generateCountriesDataBase(Scanner s, int inputCount) {
        Map<String, LinkedHashMap<String, List<String>>> countriesDataBase = new LinkedHashMap<>();

        for (int i = 0; i < inputCount; i++) {
            String[] tokens = s.nextLine().split("\\s+");

            String continent = tokens[0];
            String country = tokens[1];
            String city = tokens[2];

            countriesDataBase.putIfAbsent(continent, new LinkedHashMap<String, List<String>>());
            countriesDataBase.get(continent).putIfAbsent(country, new ArrayList<>());
            countriesDataBase.get(continent).get(country).add(city);
        }

        return countriesDataBase;
    }

    private static void printCountriesDataBase(Map<String, LinkedHashMap<String, List<String>>> countriesDataBase) {

        for (String continent : countriesDataBase.keySet()) {
            System.out.printf("%s:%n", continent);

            for (String country : countriesDataBase.get(continent).keySet()) {
                String citiesList = String.join(", ", countriesDataBase.get(continent).get(country));
                System.out.printf("%s -> %s%n", country, citiesList);
            }
            
        }
    }

}
