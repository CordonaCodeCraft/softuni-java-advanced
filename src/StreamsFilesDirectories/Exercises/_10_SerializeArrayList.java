package StreamsFilesDirectories.Exercises;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class _10_SerializeArrayList {
    public _10_SerializeArrayList() throws IOException {
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        List<Double> doubles = new ArrayList<>();
        doubles.add(1.1);
        doubles.add(2.1);
        doubles.add(8.1);
        String outputPath = "D:\\Gdrive\\Java\\Java Advanced\\Streams Files and Directories\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\ListOfDoubles.ser";
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(outputPath))) {
            oos.writeObject(doubles);
        }  catch (IOException e) {
            e.printStackTrace();
        }

        ObjectInputStream file = new ObjectInputStream(new FileInputStream("D:\\Gdrive\\Java\\Java Advanced\\Streams Files and Directories\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\ListOfDoubles.ser"));
        List<Double> restored = (List<Double>) file.readObject();

        for (Double aDouble : restored) {
            System.out.println(aDouble);

        }
    }


}
