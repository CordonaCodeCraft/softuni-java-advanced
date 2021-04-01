// Judge ready

package StreamsFilesDirectories.Lab;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class _04_ExtractIntegers {
    public static void main(String[] args) throws IOException {
        String folderPath = "D:\\Gdrive\\Java\\Java Advanced\\Streams Files and Directories\\04.Java-Advanced-Files-and-Streams-Lab-Resources\\";
        String inputFilePath = folderPath + "input.txt";
        String outputFilePath = folderPath + "03.TargetFile.txt";

        try (FileInputStream inputFile = new FileInputStream(inputFilePath); FileOutputStream outputFile = new FileOutputStream(outputFilePath)) {
            Scanner scanner = new Scanner(inputFile);
            while (scanner.hasNext()) {
                String currentLine = scanner.nextLine();
                Pattern integerPattern = Pattern.compile("\\s[0-9]+\\s");
                Matcher matcher = integerPattern.matcher(currentLine);
                while (matcher.find()) {
                    String product = matcher.group();
                    for (int i = 0; i < product.length(); i++) {
                        outputFile.write(product.charAt(i));
                    }
                    outputFile.write('\n');
                }
            }
        } catch (IOException e) {
            e.getStackTrace();
        }
    }
}
