
// Judge ready

package DefiningClasses.Exercises.CarSalesman;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static final List<Engine> enginesList = new ArrayList<>();
    private static final List<Car> carsList = new ArrayList<>();

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int enginesCount = Integer.parseInt(s.nextLine());

        feedEnginesList(s, enginesCount);

        int carsCount = Integer.parseInt(s.nextLine());

        feedCarsList(s, carsCount);

        carsList.forEach(Car::printCarSpecifications);



    }

    private static void feedEnginesList(Scanner s, int enginesCount) {

        while (--enginesCount >= 0) {

            String[] engineTokens = s.nextLine().split("\\s+");
            String engineModel = engineTokens[0];
            int enginePower = Integer.parseInt(engineTokens[1]);

            if (engineTokens.length == 4) {
                String engineDisplacement = engineTokens[2];
                String engineEfficiency = engineTokens[3];
                Engine newEngine = new Engine(engineModel, enginePower, engineDisplacement, engineEfficiency);
                enginesList.add(newEngine);
            } else if (engineTokens.length == 3) {
                Engine newEngine = new Engine(engineModel, enginePower, engineTokens[2]);
                enginesList.add(newEngine);
            } else if (engineTokens.length == 2) {
                Engine newEngine = new Engine(engineModel, enginePower);
                enginesList.add(newEngine);
            }
        }
    }

    private static void feedCarsList(Scanner s, int carsCount) {

        while (--carsCount >= 0) {

            String[] carTokens = s.nextLine().split("\\s+");
            String carModel = carTokens[0];
            String engineModel = carTokens[1];
            int engineIndex = findEngineIndex(engineModel);
            Engine carEngine = enginesList.get(engineIndex);

            if (carTokens.length == 4) {
                String carWeight = carTokens[2];
                String carColor = carTokens[3];
                Car newCar = new Car(carModel, carEngine, carWeight, carColor);
                carsList.add(newCar);
            } else if (carTokens.length == 3) {
                Car newCar = new Car(carModel, carEngine, carTokens[2]);
                carsList.add(newCar);
            } else if (carTokens.length == 2) {
                Car newCar = new Car(carModel, carEngine);
                carsList.add(newCar);
            }
        }
    }

    private static int findEngineIndex(String engineModel) {
        return enginesList
                .stream()
                .filter(e -> e.getEngineModel().equals(engineModel))
                .mapToInt(enginesList::indexOf)
                .findFirst()
                .getAsInt();
    }
}
