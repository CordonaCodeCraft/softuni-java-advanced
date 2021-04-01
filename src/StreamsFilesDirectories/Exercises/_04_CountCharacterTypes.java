
// Judge ready

package StreamsFilesDirectories.Exercises;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class _04_CountCharacterTypes {
    public static void main(String[] args) {
        String sourceDirectory = "D:\\Gdrive\\Java\\Java Advanced\\Streams Files and Directories\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\";
        Path sourcePath = Paths.get(sourceDirectory + "input.txt");
        Path targetPath = Paths.get(sourceDirectory + "02.Target.txt");
        int[] counters = feedCounters(sourcePath);
        writeToTargetFile(counters,targetPath);

    }

    private static int[] feedCounters(Path sourcePath) {
        Set<Character> vowels = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));
        Set<Character> punctuation = new HashSet<>(Arrays.asList('!', ',', '.', '?'));

        int[] counters = new int[3];

        try (BufferedReader reader = Files.newBufferedReader(sourcePath)) {
            String line = reader.readLine();

            while (line != null) {
                for (char character : line.toCharArray()) {
                    if (vowels.contains(character)) {
                        counters[0] += 1;
                    } else if (punctuation.contains(character)) {
                        counters[1] += 1;
                    } else {
                        if (!Character.isWhitespace(character)) {
                            counters[2] += 1;
                        }
                    }
                }
                line = reader.readLine();
            }
        } catch (IOException e) {
            e.getStackTrace();
        }
        return  counters;
    }

    private static void writeToTargetFile(int[] counters, Path targetPath) {
        StringBuilder product = new StringBuilder();
        product.append(String.format("Vowels: %d",counters[0])).append(System.lineSeparator());
        product.append(String.format("Consonants: %d",counters[2])).append(System.lineSeparator());
        product.append(String.format("Punctuation: %d",counters[1]));
        
        try (BufferedWriter writer = Files.newBufferedWriter(targetPath)) {
            writer.write(product.toString());
        }       catch (IOException e) {
            e.getStackTrace();
        }
    }
}
