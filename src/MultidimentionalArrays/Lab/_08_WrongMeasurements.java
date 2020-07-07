
// Judge ready

package MultidimentionalArrays.Lab;

import java.util.Arrays;
import java.util.Scanner;

public class _08_WrongMeasurements {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        StringBuilder product = new StringBuilder();
        int rowsCount = Integer.parseInt(s.nextLine());
        int[][] matrix = generateMatrix(s, rowsCount);
        int[] coordinates = extractTokens(s);
        int[][] fixedMatrix = new int[matrix.length][matrix[0].length];
        generateFixedMatrix(matrix, fixedMatrix, coordinates);
        constructProduct(fixedMatrix, product);
        System.out.println(product);


    }

    private static int[][] generateMatrix(Scanner s, int rowsCount) {
        int[][] matrix = new int[rowsCount][];
        for (int row = 0; row < matrix.length; row++) {
            matrix[row] = extractTokens(s);
        }
        return matrix;
    }

    private static int[] extractTokens(Scanner s) {
        return Arrays
                .stream(s.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
    }

    private static void generateFixedMatrix(int[][] matrix, int[][] fixedMatrix, int[] coordinates) {
        int targetInteger = matrix[coordinates[0]][coordinates[1]];

        for (int row = 0; row < matrix.length; row++) {
            for (int column = 0; column < matrix[row].length; column++) {
                int currentInteger = matrix[row][column];
                if (currentInteger == targetInteger) {
                    fixedMatrix[row][column] = calculateNewValue(matrix, targetInteger, row, column);
                } else {
                    fixedMatrix[row][column] = matrix[row][column];
                }
            }
        }
    }

    private static int calculateNewValue(int[][] matrix, int targetInteger, int row, int column) {
        int leftColumn = column - 1;
        int rightColumn = column + 1;
        int upRow = row - 1;
        int downRow = row + 1;

        boolean leftColumnInBounds = leftColumn >= 0;
        boolean rightColumnInBounds = rightColumn <= matrix[0].length - 1;
        boolean upRowInBounds = upRow >= 0;
        boolean downRowInBounds = downRow <= matrix.length - 1;

        int leftValue = 0;
        int rightValue = 0;
        int upValue = 0;
        int downValue = 0;

        if (leftColumnInBounds) {
            leftValue = matrix[row][leftColumn] == targetInteger ? 0 : matrix[row][leftColumn];
        }
        if (rightColumnInBounds) {
            rightValue = matrix[row][rightColumn] == targetInteger ? 0 : matrix[row][rightColumn];
        }

        if (upRowInBounds) {
             upValue = matrix[upRow][column] == targetInteger ? 0 : matrix[upRow][column];
        }

        if (downRowInBounds) {
            downValue = matrix[downRow][column] == targetInteger ? 0 : matrix[downRow][column];
        }
            return leftValue + rightValue + upValue + downValue;
    }

    private static void constructProduct(int[][] fixedMatrix, StringBuilder product) {
        for (int[] row : fixedMatrix) {
            for (int value : row) {
                product.append(String.format("%d ", value));
            }
            product.append(System.lineSeparator());
        }
    }
}
