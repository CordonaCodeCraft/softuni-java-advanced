
// Judge ready

package generics.exercises.generic_box_of_integers;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static final List<Box> BOXES = new ArrayList<>();

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int boxCount = Integer.parseInt(s.nextLine());

        while (--boxCount >= 0) {
           int input = Integer.parseInt(s.nextLine());
           BOXES.add(new Box<>(input));
        }

        BOXES.forEach(e -> System.out.println(e.toString()));

    }

}
