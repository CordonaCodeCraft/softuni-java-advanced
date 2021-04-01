package DefiningClasses.Exercises.SpeedRacing;

public class Car {
    private String model;
    private double fuelAmount;
    private double fuelCostPerKilometer;
    private double travelledDistance;

    public Car(String model, double fuelAmount, double fuelCostPerKilometer) {
        this.model = model;
        this.fuelAmount = fuelAmount;
        this.fuelCostPerKilometer = fuelCostPerKilometer;
        this.travelledDistance = 0;
    }

    public void driveCar(double distance) {
        this.travelledDistance += distance;
        this.fuelAmount -= distance * fuelCostPerKilometer;
    }

    public void reportInsufficientFuel() {
        System.out.println("Insufficient fuel for the drive");
    }

    public void printCarStatus() {
        System.out.printf("%s %.2f %.0f%n", model, fuelAmount, travelledDistance);
    }

    public String getModel() {
        return model;
    }

    public double getFuelCostPerKilometer() {
        return fuelCostPerKilometer;
    }

    public double getFuelAmount() {
        return fuelAmount;
    }
}
