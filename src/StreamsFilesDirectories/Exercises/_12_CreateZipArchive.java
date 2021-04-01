package StreamsFilesDirectories.Exercises;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class _12_CreateZipArchive {
    public static void main(String[] args) {
        String zipFileDestination = "D:\\Gdrive\\Java\\Java Advanced\\Streams Files and Directories\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\archive.zip";
        String sourcePath = "D:\\Gdrive\\Java\\Java Advanced\\Streams Files and Directories\\04. Java-Advanced-Files-and-Streams-Exercises-Resources";
        List<String> filesPaths = extractFilesPaths(sourcePath);

        try (ZipOutputStream zipWriter = new ZipOutputStream(new FileOutputStream(zipFileDestination))) {
            byte[] buffer = new byte[1024];

            for (String path : filesPaths) {
                File file = new File(path);

                try (FileInputStream fileReader = new FileInputStream(file)) {
                    zipWriter.putNextEntry(new ZipEntry(file.getName()));
                    int length;

                    while ((length = fileReader.read(buffer)) > 0) {
                        zipWriter.write(buffer, 0, length);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static List<String> extractFilesPaths(String sourcePath) {
        List<String> filesPaths = new ArrayList<>();
        File source = new File(sourcePath);
        File[] elements = source.listFiles();

        for (File element : elements) {
            if (element.isFile()) {
                filesPaths.add(element.getPath());
            }
        }
        return filesPaths;
    }
}
