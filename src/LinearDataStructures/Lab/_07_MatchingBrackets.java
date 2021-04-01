
// Judge ready

package LinearDataStructures.Lab;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class _07_MatchingBrackets {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String input = s.nextLine();
        List<String> subExpressions = new ArrayList<>();
        Stack<Integer> openBracketsPositions = new Stack<>();
        for (int i = 0; i < input.length(); i++) {
            char current = input.charAt(i);
            if (current == '(') {
                openBracketsPositions.push(i);
            }
            if (current == ')') {
                String subexpression = input.substring(openBracketsPositions.pop(), i + 1);
                subExpressions.add(subexpression);
            }
        }

        for (String subExpression : subExpressions) {
            System.out.println(subExpression);
        }
    }
}



