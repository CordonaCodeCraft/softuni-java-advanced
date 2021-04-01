package DefiningClasses.Exercises.CarSalesman;

public class Car {
    private String model;
    private Engine engine;
    private String weight;
    private String color;

    public void printCarSpecifications() {
        System.out.printf("%s:%n", getModel());
        engine.printEngineSpecifications();
        System.out.printf("Weight: %s%n", getWeight());
        System.out.printf("Color: %s%n", getColor());
    }

    public Car(String model, Engine engine, String weight, String color) {
        this.model = model;
        this.engine = engine;
        this.weight = weight;
        this.color = color;
    }

    public Car(String model, Engine engine, String argument) {
        this.model = model;
        this.engine = engine;

        if (Character.isDigit(argument.charAt(0))) {
            this.weight = argument;
            this.color = "n/a";
        } else {
            this.weight = "n/a";
            this.color = argument;
        }
    }

    public Car(String model, Engine engine) {
            this.model = model;
            this.engine = engine;
            this.weight = "n/a";
            this.color = "n/a";

        }

        public String getModel () {
            return model;
        }

        public String getWeight () {
            return weight;
        }

        public String getColor () {
            return color;
        }
}
