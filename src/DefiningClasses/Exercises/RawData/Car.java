package DefiningClasses.Exercises.RawData;

import java.util.Map;

public class Car {
    private String model;
    private int engineSpeed;
    private int enginePower;
    private int cargoWeight;
    private String cargoType;
    double[][] tires;

    public Car(String model, int engineSpeed, int enginePower, int cargoWeight, String cargoType, double[][] tires) {
        this.model = model;
        this.engineSpeed = engineSpeed;
        this.enginePower = enginePower;
        this.cargoWeight = cargoWeight;
        this.cargoType = cargoType;
        this.tires = tires;
    }

    public String getModel() {
        return model;
    }

    public int getEnginePower() {
        return enginePower;
    }

    public String getCargoType() {
        return cargoType;
    }

    public double[][] getTires() {
        return tires;
    }
}
