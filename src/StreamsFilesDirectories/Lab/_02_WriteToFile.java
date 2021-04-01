// Judge ready

package StreamsFilesDirectories.Lab;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class _02_WriteToFile {

    public static void main(String[] args) throws IOException {
        String sourceFilePath = "D:\\Gdrive\\Java\\Java Advanced\\Streams Files and Directories\\04.Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";
        String targetFilePath = "D:\\Gdrive\\Java\\Java Advanced\\Streams Files and Directories\\04.Java-Advanced-Files-and-Streams-Lab-Resources\\targetFile.txt";
        Set<Character> notValidCharacters = new HashSet<>();
        Collections.addAll(notValidCharacters, ',', '.', '!', '?');

        try (FileInputStream sourceFile = new FileInputStream(sourceFilePath); FileOutputStream targetFile = new FileOutputStream(targetFilePath)) {
            while (true) {
                int oneByte = sourceFile.read();
                if (oneByte < 0) {
                    break;
                } else {
                    boolean isValidCharacter = validateCharacter(oneByte, notValidCharacters);
                    if (isValidCharacter) {
                        targetFile.write(oneByte);
                    }
                }
            }
        } catch (IOException e) {
            e.getStackTrace();
        }
    }

    private static boolean validateCharacter(int oneByte, Set<Character> notValidCharacters) {
        char currentCharacter = (char) oneByte;
        return !notValidCharacters.contains(currentCharacter);
    }
}
