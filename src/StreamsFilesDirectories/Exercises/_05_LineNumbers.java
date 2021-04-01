
// Judge ready

package StreamsFilesDirectories.Exercises;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class _05_LineNumbers {
    public static void main(String[] args) {
        String sourceDirectory = "D:\\Gdrive\\Java\\Java Advanced\\Streams Files and Directories\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\";
        Path sourcePath = Paths.get(sourceDirectory + "inputLineNumbers.txt");
        Path targetPath = Paths.get(sourceDirectory + "03.Target.txt");
        StringBuilder product = new StringBuilder();
        generateProduct(sourcePath, product);
        WriteProductToTarget(targetPath,product);
    }

    private static void generateProduct(Path sourcePath, StringBuilder product) {
        try (BufferedReader reader = Files.newBufferedReader(sourcePath)) {
            int counter = 1;
            String line = reader.readLine();
            while (line != null) {
                product
                        .append(String.format("%d. %s", counter, line))
                        .append(System.lineSeparator());
                line = reader.readLine();
                counter++;
            }
        } catch (IOException e) {
            e.getStackTrace();
        }

    }

    private static void WriteProductToTarget(Path targetPath, StringBuilder product) {
        try (BufferedWriter writer = Files.newBufferedWriter(targetPath)) {
            writer.write(product.toString());
        } catch (IOException e) {
            e.getStackTrace();
        }
    }
}
