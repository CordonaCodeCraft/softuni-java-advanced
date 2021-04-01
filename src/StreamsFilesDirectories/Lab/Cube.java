package StreamsFilesDirectories.Lab;

import java.io.Serializable;

public class Cube implements Serializable {
    private String color = null;
    private double width = 0;
    private double height = 0;
    private double depth = 0;

    public Cube() {
        this.color = "brown";
        this.width = 0.0;
        this.height = 0.0;
        this.depth = 0.0;
    }

    public Cube(String color, double width, double height, double depth) {
        this.color = color;
        this.width = width;
        this.height = height;
        this.depth = depth;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getDepth() {
        return depth;
    }

    public void setDepth(double depth) {
        this.depth = depth;
    }
}
