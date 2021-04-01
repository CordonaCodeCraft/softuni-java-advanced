package DefiningClasses.Exercises.Google;

import java.util.ArrayList;
import java.util.List;

public class Person {
    private final String personName;
    private Company personCompany;
    private final List<Parent> personParents;
    private final List<Child> personChildren;
    private Car personCar;
    private final List<Pokemon> personPokemons;

    public Person(String personName) {
        this.personName = personName;
        this.personCompany = new Company();
        this.personParents = new ArrayList<>();
        this.personChildren = new ArrayList<>();
        this.personCar = new Car();
        this.personPokemons = new ArrayList<>();
    }

    public void printPersonDetails() {
        System.out.println(personName);
        System.out.println("Company:");
        if (!personCompany.getCompanyName().equals(" ")) {
            personCompany.printCompanyDetails();
        }
        System.out.println("Car:");
        if(!personCar.getCarModel().equals(" ")) {
            personCar.printCarDetails();
        }
        System.out.println("Pokemon:");
        if (!personPokemons.isEmpty()) {
            personPokemons.forEach(Pokemon::printPokemonDetails);
        }
        System.out.println("Parents:");
        if (!personParents.isEmpty()) {
            personParents.forEach(Parent::printParentDetails);
        }
        System.out.println("Children:");
        if (!personChildren.isEmpty()) {
            personChildren.forEach(Child::printChildDetails);
        }

    }

    public void setPersonCompany(Company personCompany) {
        this.personCompany = personCompany;
    }

    public void addParent(Parent parent) {
        this.personParents.add(parent);
    }

    public void addChild(Child child) {
        this.personChildren.add(child);
    }

    public void setPersonCar(Car car) {
        this.personCar = car;
    }

    public void addPokemon(Pokemon pokemon) {
        this.personPokemons.add(pokemon);
    }

    public String getPersonName() {
        return this.personName;
    }


    public static class Company {

        private String companyName;
        private String companyDepartment;
        private double salary;

        public Company() {
            this.companyName = " ";
            this.companyDepartment = " ";
            this.salary = 0.0;
        }

        private void printCompanyDetails() {
            System.out.printf("%s %s %.2f%n", companyName, companyDepartment, salary);
        }

        public Company(String companyName, String companyDepartment, double salary) {
            this.companyName = companyName;
            this.companyDepartment = companyDepartment;
            this.salary = salary;
        }

        public void updateCompanyDetails(String companyName, String companyDepartment, double salary) {
            this.companyName = companyName;
            this.companyDepartment = companyDepartment;
            this.salary = salary;
        }

        public String getCompanyName() {
            return companyName;
        }
    }

    public static class Parent {

        private final String parentName;
        private final String parentBirthday;

        public Parent(String parentName, String parentBirthday) {
            this.parentName = parentName;
            this.parentBirthday = parentBirthday;
        }

        private void printParentDetails() {
            System.out.printf("%s %s%n", parentName, parentBirthday);
        }
    }

    public static class Child {

        private final String childName;
        private final String childBirthday;

        private void printChildDetails() {
            System.out.printf("%s %s%n", childName, childBirthday);
        }

        public Child(String childName, String childBirthday) {
            this.childName = childName;
            this.childBirthday = childBirthday;
        }
    }

    public static class Car {

        private final String carModel;
        private final int carSpeed;

        private void printCarDetails() {
            System.out.printf("%s %d%n", carModel, carSpeed);
        }

        public Car() {
            this.carModel = " ";
            this.carSpeed = 0;
        }

        public Car(String carModel, int carSpeed) {
            this.carModel = carModel;
            this.carSpeed = carSpeed;
        }

        public String getCarModel() {
            return carModel;
        }
    }

    public static class Pokemon {

        private final String pokemonName;
        private final String pokemonType;

        private void printPokemonDetails() {
            System.out.printf("%s %s%n", pokemonName, pokemonType);
        }

        public Pokemon(String pokemonName, String pokemonType) {
            this.pokemonName = pokemonName;
            this.pokemonType = pokemonType;
        }
    }

}
