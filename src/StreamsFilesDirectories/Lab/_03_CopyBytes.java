
// Judge ready

package StreamsFilesDirectories.Lab;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class _03_CopyBytes {
    public static void main(String[] args) throws FileNotFoundException {
        String folderPath = "D:\\Gdrive\\Java\\Java Advanced\\Streams Files and Directories\\04.Java-Advanced-Files-and-Streams-Lab-Resources";
        String sourceFilePath = folderPath + "\\input.txt";
        String targetFilePath = folderPath + "\\newTargetFile.txt";
        
        try (FileInputStream sourceFile = new FileInputStream(sourceFilePath); FileOutputStream targetFile = new FileOutputStream(targetFilePath)) {
            while (true) {
                int character = sourceFile.read();
                if (character < 0) {
                    break;
                } else {
                    if (character == ' ' || character == '\n') {
                        targetFile.write(character);
                    }  else {
                        String digits = String.valueOf(character);
                        for (char thisCharacter : digits.toCharArray()) {
                            targetFile.write(thisCharacter);
                        }
                    }
                }
            }
        } catch (IOException e) {
            e.getStackTrace();
        }
    }
}
