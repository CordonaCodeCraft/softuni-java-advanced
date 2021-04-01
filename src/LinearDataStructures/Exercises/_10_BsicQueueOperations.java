
// Judge ready

package LinearDataStructures.Exercises;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class _10_BsicQueueOperations {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        Deque<String> queue = new ArrayDeque<>();
        String[] instructions = s.nextLine().split("\\s+");
        int queueSize = Integer.parseInt(instructions[0]);
        int removeCount = Integer.parseInt(instructions[1]);
        String targetElement = instructions[2];
        String[] elements = s.nextLine().split("\\s+");

        for (int i = 0; i < queueSize; i++) {
            queue.offer(elements[i]);
        }
        while (--removeCount >= 0) {
            queue.poll();
        }

        if (queue.isEmpty()) {
            System.out.println("0");
        } else {
            if (queue.contains(targetElement)) {
                System.out.println("true");
            } else {
                int smallestInteger = Integer.MAX_VALUE;
                while (!queue.isEmpty()) {
                    int integer = Integer.parseInt(queue.poll());
                    if (integer < smallestInteger) {
                        smallestInteger = integer;
                    }
                }
                System.out.println(smallestInteger);
            }
        }
    }
}
