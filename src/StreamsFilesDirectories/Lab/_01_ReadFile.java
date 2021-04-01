
// Judge ready

package StreamsFilesDirectories.Lab;
import javax.imageio.IIOException;
import java.io.FileInputStream;
import java.io.IOException;

public class _01_ReadFile {
    public static void main(String[] args) throws IOException {
        String filePath = "D:\\Gdrive\\Java\\Java Advanced\\Streams Files and Directories\\04.Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";

        try (FileInputStream fileStream = new FileInputStream(filePath)) {
            int oneByte = fileStream.read();

            while (oneByte >= 0) {
                System.out.printf("%s ", Integer.toBinaryString(oneByte));
                oneByte = fileStream.read();
            }
        } catch (IIOException e) {
            e.printStackTrace();
        }
    }
}
