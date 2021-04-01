package StreamsFilesDirectories.Lab;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class _09_SerializeCustomObject {
    public static void main(String[] args) throws FileNotFoundException {
        Cube cube = new Cube();
        cube.setColor("green");
        cube.setWidth(15.3);
        cube.setHeight(12.4);
        cube.setDepth(3.0);

        String outputPath = "D:\\Gdrive\\Java\\Java Advanced\\Streams Files and Directories\\04.Java-Advanced-Files-and-Streams-Lab-Resources\\save.ser";

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(outputPath))) {
            oos.writeObject(cube);

        }   catch (IOException e) {
            e.printStackTrace();
        }

    }
}
