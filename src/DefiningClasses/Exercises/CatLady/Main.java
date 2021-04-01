
// Judge ready

package DefiningClasses.Exercises.CatLady;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Lady catLady = new Lady();

        while (true) {
            String input = scanner.nextLine();

            if (input.equals("End")) {
                break;
            } else {
                String[] tokens = input.split("\\s+");
                String catType = tokens[0];
                String catName = tokens[1];
                double catParameter = Double.parseDouble(tokens[2]);

                Lady.Cat newCat = catLady.new Cat(catType,catName,catParameter);
                catLady.updateCatsDatabase(catName,newCat);
            }
        }

        String targetCat = scanner.nextLine();

        catLady
                .getCats()
                .entrySet()
                .stream()
                .filter(cat -> cat.getKey().equals(targetCat))
                .forEach(cat -> cat.getValue().printCat());
    }
}

