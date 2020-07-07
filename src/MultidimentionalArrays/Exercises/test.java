package MultidimentionalArrays.Exercises;

import java.util.ArrayDeque;
import java.util.Deque;

public class test {
    public static void main(String[] args) {
        Deque<Integer>[] test = new Deque[]{new ArrayDeque<>(), new ArrayDeque<>()};
        test[0].offer(1);
        test[0].offer(2);
        test[0].offer(3);

        test[1].push(4);
        test[1].push(5);
        test[1].push(6);

        while (!test[0].isEmpty()) {
            System.out.print(test[0].poll());
        }

        while (!test[1].isEmpty()) {
            System.out.print(test[1].pop());
        }







    }
}
