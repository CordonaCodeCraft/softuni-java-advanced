
// Judge ready

package StreamsFilesDirectories.Exercises;
import javax.imageio.IIOException;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class _01_SumLines {
    public static void main(String[] args) throws IOException {

        Path sourcePath = Paths.get("D:\\Gdrive\\Java\\Java Advanced\\Streams Files and Directories\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt");

        try (BufferedReader reader = Files.newBufferedReader(sourcePath)) {
            String line;
            while ((line = reader.readLine()) != null) {
                int sum = 0;
                for (char character : line.toCharArray()) {
                    sum += character;
                }
                System.out.println(sum);
            }




        } catch (IIOException e) {
            e.printStackTrace();
        }
    }
}
