
// Judge ready

package StreamsFilesDirectories.Exercises;
import java.io.File;
import java.util.ArrayDeque;
import java.util.Deque;

public class _08_GetFolderSize {
    public static void main(String[] args) {
        String sourceDirectory = "D:\\Gdrive\\Java\\Java Advanced\\Streams Files and Directories\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\Exercises Resources";
        File root = new File(sourceDirectory);
        File[] elements = root.listFiles();
        Deque<File> elementsQueue = new ArrayDeque<>();

        for (File element : elements) {
            elementsQueue.offer(element);
        }
        
        int total = 0;

        while (!elementsQueue.isEmpty()) {
            if (elementsQueue.peek().isFile()) {
                   total += elementsQueue.poll().length();
            } else {
                elements = elementsQueue.poll().listFiles();
                for (File element : elements) {
                    if (element.isDirectory()) {
                        elementsQueue.offer(element);
                    } else {
                        total += element.length();
                    }
                }
            }
        }

        System.out.printf("Folder size: %d", total);
















    }

}
