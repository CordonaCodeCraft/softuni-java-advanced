
// Judge ready

package DefiningClasses.Lab.CarWithoutConstructors;

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
            String make = tokens[0];
            String model = tokens[1];
            int horsePower = Integer.parseInt(tokens[2]);
            Car car = new Car();
            car.setMake(make);
            car.setModel(model);
            car.setHorsePower(horsePower);
            carList.add(car);
        }

       carList.forEach(e ->System.out.print(e.getInfo()));
    }
}
