
// Judge ready

package StreamsFilesDirectories.Lab;
import java.io.File;
public class _07_ListFiles {
    public static void main(String[] args) {
        File file = new File("D:\\Gdrive\\Java\\Java Advanced\\Streams Files and Directories\\04.Java-Advanced-Files-and-Streams-Lab-Resources\\Files-and-Streams");
        File[] files = file.listFiles();
        for (File thisFile : files) {
            if (thisFile.isFile()) {
                String fileName = thisFile.getName();
                long fileSize = thisFile.length();
                System.out.printf("%s: [%d]%n", fileName, fileSize);
            }
        }
    }
}
