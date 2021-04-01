
// Judge ready

package DefiningClasses.Exercises.Google;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    private static final Map<String, Person> PERSONS_DATABASE = new HashMap<>();

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        while (true) {
            String input = s.nextLine();
            if ("End".equals(input)) {
                break;
            } else {
                String[] tokens = input.split("\\s+");

                String person = tokens[0];

                addPersonToDatabase(person);

                String inputType = tokens[1];

                switch (inputType) {
                    case "company":
                        setPersonCompany(person, tokens);
                        break;
                    case "parents":
                        updateParentsList(person, tokens);
                        break;
                    case "children":
                        updateChildrenList(person, tokens);
                        break;
                    case "car":
                        setPersonCar(person, tokens);
                        break;
                    case "pokemon":
                        updatePokemonList(person,tokens);
                        break;
                }
            }
        }

        String targetPerson = s.nextLine();

        PERSONS_DATABASE
                .values()
                .stream()
                .filter(person -> person.getPersonName().equals(targetPerson))
                .forEach(Person::printPersonDetails);

    }

    private static void addPersonToDatabase(String person) {
        Person newPerson = new Person(person);
        PERSONS_DATABASE.putIfAbsent(person, newPerson);
    }

    private static void setPersonCompany(String person, String[] tokens) {
        String companyName = tokens[2];
        String companyPosition = tokens[3];
        double salary = Double.parseDouble(tokens[4]);

        Person.Company newCompany = new Person.Company(companyName, companyPosition, salary);

        PERSONS_DATABASE.get(person).setPersonCompany(newCompany);

    }

    private static void updateParentsList(String person, String[] tokens) {
        String parentName = tokens[2];
        String parentBirthday = tokens[3];

        Person.Parent newParent = new Person.Parent(parentName, parentBirthday);

        PERSONS_DATABASE.get(person).addParent(newParent);

    }

    private static void updateChildrenList(String person, String[] tokens) {
        String childName = tokens[2];
        String childBirthday = tokens[3];

        Person.Child newChild = new Person.Child(childName, childBirthday);

        PERSONS_DATABASE.get(person).addChild(newChild);


    }

    private static void setPersonCar(String person, String[] tokens) {
        String carName = tokens[2];
        int carSpeed = Integer.parseInt(tokens[3]);

        Person.Car newCar = new Person.Car(carName, carSpeed);

        PERSONS_DATABASE.get(person).setPersonCar(newCar);


    }

    private static void updatePokemonList(String person, String[] tokens) {
        String pokemonName = tokens[2];
        String pokemonType = tokens[3];

        Person.Pokemon newPokemon = new Person.Pokemon(pokemonName, pokemonType);

        PERSONS_DATABASE.get(person).addPokemon(newPokemon);

    }

}
