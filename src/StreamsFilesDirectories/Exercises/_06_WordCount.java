package StreamsFilesDirectories.Exercises;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class _06_WordCount {
    public static void main(String[] args) {
        String sourceDirectory = "D:\\Gdrive\\Java\\Java Advanced\\Streams Files and Directories\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\";
        Path sourcePath = Paths.get(sourceDirectory + "words.txt");
        Path textPath = Paths.get(sourceDirectory + "text.txt");
        Path targetPath = Paths.get(sourceDirectory + "04.Target.txt");
        StringBuilder product = new StringBuilder();
        Map<String, Integer> words = generateWordsMap(sourcePath);
        countWordsFromText(words, textPath);
        generateProduct(words, product);
        CopyProductToTarget(product, targetPath);
    }

    private static Map<String, Integer> generateWordsMap(Path sourcePath) {
        Map<String, Integer> words = new HashMap<>();

        try (Scanner scanner = new Scanner(Files.newBufferedReader(sourcePath))) {
            while (scanner.hasNext()) {
                words.putIfAbsent(scanner.next(), 0);
            }
        } catch (IOException e) {
            e.getStackTrace();
        }
        return words;
    }

    private static void countWordsFromText(Map<String, Integer> words, Path textPath) {
        try (Scanner scanner = new Scanner(Files.newBufferedReader(textPath))) {
            while (scanner.hasNext()) {
                String word = scanner.next();
                if (words.containsKey(word)) {
                    int count = words.get(word);
                    words.put(word, count + 1);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void generateProduct(Map<String, Integer> words, StringBuilder product) {
        words
                .entrySet()
                .stream()
                .sorted((e1, e2) -> Integer.compare(e2.getValue(), e1.getValue()))
                .forEach(e -> product.append(String.format("%s - %d", e.getKey(), e.getValue())).append(System.lineSeparator()));
    }

    private static void CopyProductToTarget(StringBuilder product, Path targetPath) {
        try (BufferedWriter writer = Files.newBufferedWriter(targetPath)) {
            writer.write(product.toString());
        } catch (IOException e) {
            e.getStackTrace();
        }
    }
}
