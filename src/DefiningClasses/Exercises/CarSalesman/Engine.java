package DefiningClasses.Exercises.CarSalesman;

public class Engine {
    private String engineModel;
    private int enginePower;
    private String engineDisplacement;
    private String engineEfficiency;

    public void printEngineSpecifications() {
        System.out.printf("%s:%n", getEngineModel());
        System.out.printf("Power: %s%n", getEnginePower());
        System.out.printf("Displacement: %s%n", getEngineDisplacement());
        System.out.printf("Efficiency: %s%n", getEngineEfficiency());
    }




    public Engine(String engineModel, int enginePower, String engineDisplacement, String engineEfficiency) {
        this.engineModel = engineModel;
        this.enginePower = enginePower;
        this.engineDisplacement = engineDisplacement;
        this.engineEfficiency = engineEfficiency;
    }

    public Engine(String engineModel, int enginePower, String argument) {
        this.engineModel = engineModel;
        this.enginePower = enginePower;

        if (Character.isDigit(argument.charAt(0))) {
            this.engineDisplacement = argument;
            this.engineEfficiency = "n/a";
        } else {
            this.engineDisplacement = "n/a";
            this.engineEfficiency = argument;
        }
    }

    public Engine(String engineModel, int enginePower) {
        this.engineModel = engineModel;
        this.enginePower = enginePower;
        this.engineDisplacement = "n/a";
        this.engineEfficiency = "n/a";
    }

    public String getEngineModel() {
        return engineModel;
    }

    public int getEnginePower() {
        return enginePower;
    }

    public String getEngineDisplacement() {
        return engineDisplacement;
    }

    public String getEngineEfficiency() {
        return engineEfficiency;
    }
}
