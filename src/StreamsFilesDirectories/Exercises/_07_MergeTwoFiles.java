
// Judge ready

package StreamsFilesDirectories.Exercises;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class _07_MergeTwoFiles {
    public static void main(String[] args) {
        String sourceDirectory = "D:\\Gdrive\\Java\\Java Advanced\\Streams Files and Directories\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\";
        Path firstFilePath = Paths.get(sourceDirectory + "inputOne.txt");
        Path secondFilePath = Paths.get(sourceDirectory + "inputTwo.txt");
        Path targetFilePath = Paths.get(sourceDirectory + "05.Target.txt");
        StringBuilder product = new StringBuilder();
        feedProduct(firstFilePath, product);
        feedProduct(secondFilePath, product);
        WriteProductToTargetFile(product, targetFilePath);
    }

    private static void feedProduct(Path filePath, StringBuilder product) {
         try (BufferedReader reader = Files.newBufferedReader(filePath)) {
              String line = reader.readLine();
              while (line != null){
                   product
                           .append(line)
                           .append(System.lineSeparator());
                  line = reader.readLine();
              }
         } catch (IOException e) {
             e.printStackTrace();
         }
    }

    private static void WriteProductToTargetFile(StringBuilder product, Path targetFilePath) {
        try (BufferedWriter writer = Files.newBufferedWriter(targetFilePath)) {
                 writer.write(product.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
