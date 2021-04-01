
// Judge ready

package LinearDataStructures.Lab;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class _09_MathPotato {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String[] input = s.nextLine().split(" ");
        int num = Integer.parseInt(s.nextLine());
        Queue<String> childrenCircle = new LinkedList<>();
        Collections.addAll(childrenCircle, input);
        int cycleCount = 1;

        while (childrenCircle.size() > 1) {
            for (int i = 1; i < num; i++) {
                childrenCircle.offer(childrenCircle.poll());
            }
            boolean isPrimeCycle = validatePrimeCycle(cycleCount);
            if (isPrimeCycle) {
                System.out.printf("Prime %s%n", childrenCircle.peek());
            } else {
                System.out.printf("Removed %s%n", childrenCircle.poll());
            }
            cycleCount++;
        }
        System.out.printf("Last is %s%n", childrenCircle.peek());
    }
    private static boolean validatePrimeCycle(int cycle) {
        boolean isPrime = true;
        if (cycle == 1) {
            isPrime = false;
        } else {
            for (int i = 2; i <= cycle / 2; ++i) {
                if (cycle % i == 0) {
                    isPrime = false;
                    break;
                }
            }
        }
        return isPrime;
    }
}
