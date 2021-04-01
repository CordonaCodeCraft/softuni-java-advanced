
// Judge ready

package StreamsFilesDirectories.Lab;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;

public class _06_SortLines {
    public static void main(String[] args) throws IOException {
        Path inputPath = Paths.get("D:\\Gdrive\\Java\\Java Advanced\\Streams Files and Directories\\04.Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt");
        String outputPath = "D:\\Gdrive\\Java\\Java Advanced\\Streams Files and Directories\\04.Java-Advanced-Files-and-Streams-Lab-Resources\\05.TargetFile.txt";
        List<String> lines = Files.readAllLines(inputPath);
        Collections.sort(lines);
        PrintWriter writer = new PrintWriter(outputPath);
        for (String line : lines) {
            writer.println(line);
            writer.flush();
        }
    }
}
