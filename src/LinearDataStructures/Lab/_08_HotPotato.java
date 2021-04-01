// Judge ready

package LinearDataStructures.Lab;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class  _08_HotPotato {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String[] input = s.nextLine().split("\\s+");
        int initialCount = Integer.parseInt(s.nextLine());
        Queue<String> childrenCircle = new LinkedList<>();
        Collections.addAll(childrenCircle, input);
        int currentCount = initialCount;
        while (childrenCircle.size() > 1) {
            currentCount--;
            boolean toRemoveChild = currentCount == 0;
            if (toRemoveChild) {
                removeChild(childrenCircle);
                currentCount = initialCount;
            } else {
                moveChildAtQueueTail(childrenCircle);
            }
        }
        System.out.printf("Last is %s", childrenCircle.peek());
    }

    private static void removeChild(Queue<String> queue) {
        System.out.printf("Removed %s%n", queue.element());
        queue.remove();
    }
    private static void moveChildAtQueueTail(Queue<String> queue) {
        queue.offer(queue.poll());
    }
}
