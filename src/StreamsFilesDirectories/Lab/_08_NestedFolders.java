
// TODO: 24.07.2020 г. Judge not ready 0 / 100

package StreamsFilesDirectories.Lab;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class _08_NestedFolders {
    public static void main(String[] args) {
        StringBuilder product = new StringBuilder();
        String path = "D:\\Gdrive\\Java\\Java Advanced\\Streams Files and Directories\\04.Java-Advanced-Files-and-Streams-Lab-Resources\\Files-and-Streams";
        List<String> directoriesList = new ArrayList<>();
        File element = new File(path);
        directoriesList.add(element.getName());
        traverseDirectory(element, directoriesList);

        for (String directory : directoriesList) {
            System.out.printf("%s%n", directory);
        }
        
        System.out.printf("%d folders", directoriesList.size());
    }

    private static void traverseDirectory(File element, List<String> directoriesList) {

        if (element.isDirectory()) {

            File[] elementContent = element.listFiles();

            for (File currentElement : elementContent) {
                if (currentElement.isDirectory()) {
                    directoriesList.add(currentElement.getName());
                }
            }

            for (File currentElement : elementContent) {
                if (currentElement.isDirectory()) {
                    traverseDirectory(currentElement, directoriesList);
                }
            }
        }

    }
}
