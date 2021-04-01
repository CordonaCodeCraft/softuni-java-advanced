
// Judge ready

package StreamsFilesDirectories.Exercises;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class _02_SumBytes {
    public static void main(String[] args) throws IOException {

        Path sourcePath = Paths.get("D:\\Gdrive\\Java\\Java Advanced\\Streams Files and Directories\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt");
        int codesSum = 0;

        try (BufferedReader reader = Files.newBufferedReader(sourcePath)) {
            String line;
            while ((line = reader.readLine()) != null) {
                for (char character : line.toCharArray()) {
                    codesSum += character;
                }
            }
        } catch (IOException e) {
            e.getStackTrace();
        }

        System.out.println(codesSum);
    }
}
