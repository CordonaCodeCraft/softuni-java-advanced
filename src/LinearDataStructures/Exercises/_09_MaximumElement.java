
// Judge ready

package LinearDataStructures.Exercises;

import java.util.*;

public class _09_MaximumElement {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        Deque<Integer> stack = new ArrayDeque<>();
        int commandCount = Integer.parseInt(s.nextLine());
        while (--commandCount >= 0) {
            String[] tokens = s.nextLine().split("\\s+");
            String command = findCommand(tokens[0]);
            switch (command) {
                case "Push":
                    int currentInteger = Integer.parseInt(tokens[1]);
                    stack.push(currentInteger);
                    break;
                case "Delete":
                    stack.pop();
                    break;
                case "Print":
                    System.out.println(Collections.max(stack));
                    break;
            }
        }
    }
    private static String findCommand(String token) {
        switch (token) {
            case "1":
                return "Push";
            case "2":
                return "Delete";
            case "3":
                return "Print";
            default: return "x";
        }
    }
}
