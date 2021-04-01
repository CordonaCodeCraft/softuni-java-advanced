
// Judge ready

package DefiningClasses.Lab.CarWithConstructors;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int carCount = Integer.parseInt(s.nextLine());
        List<Car> carList = new ArrayList<>();

        while (--carCount >= 0) {
            String[] tokens = s.nextLine().split("\\s+");
            if (tokens.length == 1) {
                String make = tokens[0];
                Car thisCar = new Car(make);
                carList.add(thisCar);
            } else {
                String make = tokens[0];
                String model = tokens[1];
                int horsePower = Integer.parseInt(tokens[2]);
                Car thisCar = new Car(make,model,horsePower);
                carList.add(thisCar);
            }
        }
        carList.forEach(e -> System.out.println(e.getInfo()));
    }
}
