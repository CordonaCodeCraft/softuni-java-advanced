// Judge ready

package DefiningClasses.Exercises.SpeedRacing;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static final List<Car> carsList = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int carsCount = Integer.parseInt(scanner.nextLine());
        feedCarsList(scanner, carsCount);

        while (true) {
            String input = scanner.nextLine();

            if ("End".equals(input)) {
                break;
            } else {
                String[] tokens = input.split("\\s+");
                String targetCar = tokens[1];
                double distance = Double.parseDouble(tokens[2]);
                int targetCarIndex = findTargetCarIndex(targetCar);
                boolean inDriveRange = confirmDriveRange(targetCarIndex, distance);

                if (inDriveRange) {
                    carsList.get(targetCarIndex).driveCar(distance);
                } else {
                    carsList.get(targetCarIndex).reportInsufficientFuel();
                }
            }
        }

        carsList.forEach(Car::printCarStatus);


    }

    private static void feedCarsList(Scanner scanner, int carsCount) {

        while (--carsCount >= 0) {
            String[] tokens = scanner.nextLine().split("\\s+");
            String name = tokens[0];
            double fuelAmount = Double.parseDouble(tokens[1]);
            double fuelCostPerKilometer = Double.parseDouble(tokens[2]);
            Car currentCar = new Car(name, fuelAmount, fuelCostPerKilometer);
            carsList.add(currentCar);
        }
    }

    private static boolean confirmDriveRange(int targetCarIndex, double distance) {

        double fuelCostPerKilometer = carsList.get(targetCarIndex).getFuelCostPerKilometer();

        double availableFuel = carsList.get(targetCarIndex).getFuelAmount();

        return distance * fuelCostPerKilometer <= availableFuel;

    }

    private static int findTargetCarIndex(String targetCar) {

        return carsList
                .stream()
                .filter(e -> e.getModel().equals(targetCar))
                .mapToInt(carsList::indexOf)
                .findFirst()
                .orElse(0);

    }

}
