
// Judge ready

package generics.exercises.generic_count_method_strings;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<Box<String>> boxes = new ArrayList<>();
        Scanner s = new Scanner(System.in);
        int inputsCount = Integer.parseInt(s.nextLine());
        while (--inputsCount >= 0) {
            String input = s.nextLine();
            boxes.add(new Box<>(input));
        }

        String element = s.nextLine();

        int greaterThanElementCount = calculateCount(boxes,element);

        System.out.println(greaterThanElementCount);
        



    }

    private static int calculateCount(List<? extends Box> list, String element) {
        int count = 0;

        for (Box box : list) {
            if (box.getValue().compareTo(element) > 0) {
                     count++;
            }
        }

        return count;

    }


}
