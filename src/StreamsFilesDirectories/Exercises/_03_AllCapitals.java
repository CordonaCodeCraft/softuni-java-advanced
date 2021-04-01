
// Judge ready

package StreamsFilesDirectories.Exercises;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class _03_AllCapitals {
    public static void main(String[] args) throws IOException {

        Path sourcePath = Paths.get("D:\\Gdrive\\Java\\Java Advanced\\Streams Files and Directories\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt");
        Path targetPath = Paths.get("D:\\Gdrive\\Java\\Java Advanced\\Streams Files and Directories\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\01.Target.txt");

        try (BufferedReader reader = Files.newBufferedReader(sourcePath); BufferedWriter writer = Files.newBufferedWriter(targetPath)) {
            String line = reader.readLine();
            while (line != null) {
                writer.write(line.toUpperCase());
                writer.write('\n');
                writer.flush();
                line = reader.readLine();
            }
        } catch (IOException e) {
            e.getStackTrace();
        }








    }
}
