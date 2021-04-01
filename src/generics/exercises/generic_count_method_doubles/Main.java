
// Judge ready

package generics.exercises.generic_count_method_doubles;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<Box<Double>> boxes = new ArrayList<>();

        Scanner s = new Scanner(System.in);
        int inputsCount = Integer.parseInt(s.nextLine());
        while (--inputsCount >= 0) {
            double input = Double.parseDouble(s.nextLine());
            boxes.add(new Box<>(input));
        }

        double element = Double.parseDouble(s.nextLine());

        int greaterThanElementCount = calculateCount(boxes, element);

        System.out.println(greaterThanElementCount);

        double one = 1.0;
        double two = 2.0;



    }

    private static int calculateCount(List<? extends Box> list, double element) {
        int count = 0;

        for (Box box : list) {
            if (box.getValue().compareTo(element) > 0) {
                count++;
            }
        }

        return count;

    }

}

