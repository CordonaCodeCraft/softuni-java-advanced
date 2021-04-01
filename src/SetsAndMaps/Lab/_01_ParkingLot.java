// Judge ready

package SetsAndMaps.Lab;
import java.util.*;

public class _01_ParkingLot {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        Set<String> parkingRegister = new LinkedHashSet<>();

        while (true) {
            String command = s.nextLine();
            if ("END".equals(command)) {
                break;
            } else {
                String[] tokens = command.split(", ");
                String direction = tokens[0];
                String registrationPlate = tokens[1];
                if ("IN".equals(direction)) {
                    parkingRegister.add(registrationPlate);
                }   else {
                    parkingRegister.remove(registrationPlate);
                }
            }
        }

        printParkingRegister(parkingRegister);
    }

    private static void printParkingRegister(Set<String> parkingRegister) {
        if (parkingRegister.isEmpty()) {
            System.out.println("Parking Lot is Empty");
        } else {
            for (String plate : parkingRegister) {
                System.out.printf("%s%n",plate);
            }
        }
    }
}
