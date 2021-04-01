
// Judge ready

package iterators_and_comparators.exercises.pet_clinics;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    private static final Map<String, Pet> PETS = new HashMap<>();
    private static final Map<String, Clinic> CLINICS = new HashMap<>();

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int commandsCount = Integer.parseInt(s.nextLine());

        while (--commandsCount >= 0) {

            String[] tokens = s.nextLine().split("\\s+");
            String command = tokens[0];

            switch (command) {
                case "Create":
                    String newInstanceType = tokens[1];

                    switch (newInstanceType) {
                        case "Pet":
                            createNewPet(tokens);
                            break;
                        case "Clinic":
                            createNewClinic(tokens);
                            break;
                    }

                    break;
                case "Add":
                    addPetToClinic(tokens);
                    break;
                case "Release": {
                    String clinicName = tokens[1];
                    CLINICS.get(clinicName).releaseAnimal();
                    break;
                }
                case "HasEmptyRooms": {
                    String clinicName = tokens[1];
                    System.out.println(CLINICS.get(clinicName).hasEmptyRooms());
                    break;
                }

                case "Print": {
                    String clinicName = tokens[1];
                    boolean printEntireClinic = tokens.length == 2;

                    if (printEntireClinic) {
                        CLINICS.get(clinicName).printEntireClinic();
                    } else {
                        int roomNumber = Integer.parseInt(tokens[2]) - 1;
                        CLINICS.get(clinicName).printRoom(roomNumber);
                    }
                    break;
                }
            }
        }

    }

    private static void createNewPet(String[] tokens) {
        String name = tokens[2];
        int age = Integer.parseInt(tokens[3]);
        String type = tokens[4];
        PETS.putIfAbsent(name, new Pet(name, age, type));
    }

    private static void createNewClinic(String[] tokens) {
        String name = tokens[2];
        int roomsCount = Integer.parseInt(tokens[3]);
        boolean isOddCount = roomsCount % 2 != 0;

        if (isOddCount) {
            CLINICS.putIfAbsent(name, new Clinic(name, roomsCount));
        } else {
            System.out.println("Invalid Operation!");
        }
    }

    private static void addPetToClinic(String[] tokens) {
        String petName = tokens[1];
        String clinicName = tokens[2];

        if (PETS.containsKey(petName)) {
            Pet pet = PETS.get(petName);
            if (CLINICS.containsKey(clinicName)) {
                CLINICS.get(clinicName).distributePet(pet);
                PETS.remove(petName);
            }
        }
    }
}
