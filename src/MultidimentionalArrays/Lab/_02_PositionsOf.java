
// Judge ready

package MultidimentionalArrays.Lab;
import java.util.Arrays;
import java.util.Scanner;

public class _02_PositionsOf {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        StringBuilder product = new StringBuilder();
        int[] matrixDimensions = extractTokens(s.nextLine());
        int[][] matrix = generateMatrix(s, matrixDimensions);
        int targetInteger = Integer.parseInt(s.nextLine());
        traverseMatrixAndSearchForTargetInteger(product, matrix, targetInteger);
        boolean targetIntegerNotFound = product.length() == 0;
        if (targetIntegerNotFound) {
            System.out.println("not found");
        } else {
            System.out.println(product);
        }
    }

    private static int[] extractTokens(String nextLine) {
        return Arrays
                .stream(nextLine.split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
    }

    private static int[][] generateMatrix(Scanner s, int[] leftMatrixParameters) {
        int rows = leftMatrixParameters[0];
        int columns = leftMatrixParameters[1];
        int[][] matrix = new int[rows][columns];
        for (int row = 0; row < rows; row++) {
            matrix[row] = extractTokens(s.nextLine()).clone();
        }
        return matrix;
    }

    private static void traverseMatrixAndSearchForTargetInteger(StringBuilder product, int[][] matrix, int targetInteger) {
        int rows = matrix.length;
        int columns = matrix[0].length;
        for (int row = 0; row < rows; row++) {
            for (int column = 0; column < columns; column++) {
                int currentInteger = matrix[row][column];
                if (currentInteger == targetInteger) {
                    product.append(String.format("%d %d",row,column))
                            .append(System.lineSeparator());
                }
            }
        }
    }
}
