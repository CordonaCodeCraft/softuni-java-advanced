// Judge ready

package generics.exercises.generic_swap_method_integers;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main<T> {

    private static final List<Box<Integer>> BOXES = new ArrayList<>();

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int inputCount = Integer.parseInt(s.nextLine());

        while (--inputCount >= 0) {
            int input = Integer.parseInt(s.nextLine());
            BOXES.add(new Box<>(input));
        }

        List<Box<Integer>> swappedList = swapPositions(BOXES, s);

        swappedList.forEach(e -> System.out.println(e.toString()));


    }

    private static <T> List<T> swapPositions(List<T> list, Scanner scanner) {
        List<T> buffer = new ArrayList<>(list);
        String[] tokens = scanner.nextLine().split("\\s+");
        int firstIndex = Integer.parseInt(tokens[0]);
        int secondIndex = Integer.parseInt(tokens[1]);
        buffer.add(buffer.get(firstIndex));
        buffer.set(firstIndex, buffer.get(secondIndex));
        buffer.set(secondIndex, buffer.get(buffer.size() - 1));
        buffer.remove(buffer.size() - 1);
        return buffer;
    }

}