package StreamsFilesDirectories.Exercises;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class _09_CopyPicture {
    public static void main(String[] args) throws FileNotFoundException {
        String sourceImagePath = "D:\\Gdrive\\Inbox\\Girl&Boy.jpg";
        String targetFilePath = "D:\\Gdrive\\Inbox\\ picture-copy.jpg";

        try (FileInputStream reader = new FileInputStream(sourceImagePath); FileOutputStream writer = new FileOutputStream(targetFilePath)) {
            byte[] buffer = new byte[1024];
            int length = 0;
            while ((length = reader.read(buffer)) > 0) {
                writer.write(buffer, 0, length);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
