
// TODO: 06.08.2020 г. Judge not ready 80 / 100

package DefiningClasses.Exercises.RawData;

import java.util.*;

public class Main {
    private static final List<Car> carsList = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int counter = Integer.parseInt(scanner.nextLine());
        generateCarsList(scanner, counter);

        String filterType = scanner.nextLine();

        if ("fragile".equals(filterType)) {

            carsList
                    .stream()
                    .filter(e -> e.getCargoType().equals("fragile"))
                    .filter(e -> averageTiresPressure(e) < 1)
                    .forEach(e -> System.out.println(e.getModel()));
        } else {

            carsList
                    .stream()
                    .filter(e -> e.getEnginePower() > 250)
                    .forEach(e -> System.out.println(e.getModel()));
        }
    }

    private static double averageTiresPressure(Car e) {

        return Arrays
                .stream(e.getTires())
                .mapToDouble(a -> a[0])
                .average()
                .getAsDouble();


    }

    private static void generateCarsList(Scanner scanner, int counter) {

        while (--counter >= 0) {

            String[] tokens = scanner.nextLine().split("\\s+", 6);

            String model = tokens[0];
            int engineSpeed = Integer.parseInt(tokens[1]);
            int enginePower = Integer.parseInt(tokens[2]);
            int cargoWeight = Integer.parseInt(tokens[3]);
            String cargoType = tokens[4];
            double[][] tires = feedTiresMatrix(tokens[5]);

            Car currentCar = new Car(model, engineSpeed, enginePower, cargoWeight, cargoType, tires);

            carsList.add(currentCar);
        }
    }

    private static double[][] feedTiresMatrix(String token) {

        double[][] tires = new double[4][2];

        Deque<Double> tiresTokens = new ArrayDeque<>();

        Arrays
                .stream(token.split("\\s+"))
                .mapToDouble(Double::parseDouble)
                .boxed()
                .forEach(tiresTokens::offer);

        for (double[] tire : tires) {
            for (int column = 0; column < tire.length; column++) {
                tire[column] = tiresTokens.remove();
            }
        }

        return tires;
    }
}
