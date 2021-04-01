
// Judge ready

package LinearDataStructures.Exercises;
import java.util.*;

public class _12_BalancedParentheses {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        Deque<Character> sequence = generateSequence(s.nextLine());
        Stack<Character> stack = new Stack<>();
        boolean impossibleBalance = sequence.size() % 2 != 0;
        if (impossibleBalance) {
            System.out.println("NO");
        } else {
            while (!sequence.isEmpty()) {
                if (stack.empty()) {
                    stack.push(sequence.poll());
                } else {
                    char currentParenthesis = sequence.remove();
                    char previousParenthesis = stack.peek();
                    boolean isClosingParenthesis = verifyClosingParenthesis(currentParenthesis);
                    if (isClosingParenthesis) {
                        boolean balancedParentheses = verifyBalancedParentheses(currentParenthesis, previousParenthesis);
                        if (balancedParentheses) {
                            boolean isLastElementInSequence = sequence.size() == 0;
                            if (isLastElementInSequence) {
                                System.out.println("YES");
                                break;
                            } else {
                                stack.pop();
                            }
                        } else {
                            System.out.println("NO");
                            break;
                        }
                    } else {
                        stack.push(currentParenthesis);
                    }
                }
            }
        }
    }

    private static Deque<Character> generateSequence(String nextLine) {
        Deque<Character> sequence = new ArrayDeque<>();
        nextLine
                .chars()
                .forEach(e -> sequence.offer((char) e));

        return sequence;

    }

    private static boolean verifyClosingParenthesis(char currentParenthesis) {
        return currentParenthesis == '}'
                || currentParenthesis == ')'
                || currentParenthesis == ']';

    }

    private static boolean verifyBalancedParentheses(char currentParenthesis, char previousParenthesis) {
        switch (previousParenthesis) {
            case '{':
                if (currentParenthesis == '}') {
                    return true;
                }
            case '(':
                if (currentParenthesis == ')') {
                    return true;
                }
            case '[':
                if (currentParenthesis == ']') {
                    return true;
                }
            default:
                return false;
        }
    }

}
