// Judge ready

package MultidimentionalArrays.Lab;

import java.util.Arrays;
import java.util.Scanner;

public class _01_CompareMatrices {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int[] leftMatrixDimensions = extractParameters(s.nextLine());
        int[][] leftMatrix = generateMatrix(s, leftMatrixDimensions);
        int[] rightMatrixDimensions = extractParameters(s.nextLine());
        int[][] rightMatrix = generateMatrix(s, leftMatrixDimensions);
        boolean initialEquality = Arrays.equals(leftMatrixDimensions, rightMatrixDimensions);
        boolean areEqual = true;

        if (initialEquality) {
            areEqual = traverseMatrices(leftMatrix, rightMatrix);
        } else {                                                
            areEqual = false;
        }
        if (areEqual) {
            System.out.println("equal");
        } else {
            System.out.println("not equal");
        }
    }

    private static int[][] generateMatrix(Scanner s, int[] leftMatrixParameters) {
        int rows = leftMatrixParameters[0];
        int columns = leftMatrixParameters[1];
        int[][] matrix = new int[rows][columns];
        for (int row = 0; row < rows; row++) {
            int[] sourceRow = extractParameters(s.nextLine());
            matrix[row] = sourceRow.clone();
        }
        return matrix;
    }

    private static int[] extractParameters(String nextLine) {
        return Arrays
                .stream(nextLine.split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
    }

    private static boolean traverseMatrices(int[][] leftMatrix, int[][] rightMatrix) {
        boolean areEqual = true;
        int rowsCount = leftMatrix.length;
        for (int row = 0; row < rowsCount; row++) {
            areEqual = Arrays.equals(leftMatrix[row], rightMatrix[row]);
            if (!areEqual) {
                return false;
            }
        }
        return areEqual;
    }
}
