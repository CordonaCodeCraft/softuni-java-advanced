// Judge ready

package StreamsFilesDirectories.Lab;

import java.io.*;

public class _05_WriteEveryThirdLine {
    public static void main(String[] args) throws IOException {
        String folderPath = "D:\\Gdrive\\Java\\Java Advanced\\Streams Files and Directories\\04.Java-Advanced-Files-and-Streams-Lab-Resources\\";
        String inputFilePath = folderPath + "input.txt";
        String outputFilePath = folderPath + "04.TargetFile.txt";
        
        try (BufferedReader in = new BufferedReader(new FileReader(inputFilePath)); PrintWriter out = new PrintWriter(new FileWriter(outputFilePath))) {
            int counter = 1;
            while (in.readLine() != null) {
                counter++;
                if (counter == 3) {
                    String currentLine = in.readLine();
                    out.println(currentLine);
                    counter = 1;
                }
            }
        }  catch (IOException e) {
            e.getStackTrace();
        }





    }
}
