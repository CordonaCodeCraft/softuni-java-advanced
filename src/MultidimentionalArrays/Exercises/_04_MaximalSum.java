// Judge ready

package MultidimentionalArrays.Exercises;

import java.util.Scanner;

public class  _04_MaximalSum {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String[] dimensions = s.nextLine().split("\\s+");
        int rowsCount = Integer.parseInt(dimensions[0]);
        int columnsCount = Integer.parseInt(dimensions[1]);
        int[][] matrix = new int[rowsCount][columnsCount];

        for (int row = 0; row < rowsCount; row++) {
            String[] tokens = s.nextLine().split("\\s+");
            for (int column = 0; column < columnsCount; column++) {
                matrix[row][column] = Integer.parseInt(tokens[column]);
            }
        }

        int bestSum = Integer.MIN_VALUE;
        int[] bestSubMatrixValues = new int[9];

        for (int row = 0; row < matrix.length - 2; row++) {
            for (int col = 0; col < matrix[row].length - 2; col++) {
                int currentSum = calculateCurrentSum(matrix, row, col);
                if (currentSum > bestSum) {
                    bestSum = currentSum;
                    bestSubMatrixValues[0] = matrix[row][col];
                    bestSubMatrixValues[1] = matrix[row][col + 1];
                    bestSubMatrixValues[2] = matrix[row][col + 2];
                    bestSubMatrixValues[3] = matrix[row + 1][col];
                    bestSubMatrixValues[4] = matrix[row + 1][col + 1];
                    bestSubMatrixValues[5] = matrix[row + 1][col + 2];
                    bestSubMatrixValues[6] = matrix[row + 2][col];
                    bestSubMatrixValues[7] = matrix[row + 2][col + 1];
                    bestSubMatrixValues[8] = matrix[row + 2][col + 2];
                }
            }
        }
        
        System.out.printf("Sum = %d%n", bestSum);
        printResult(bestSubMatrixValues);
    }

    private static int calculateCurrentSum(int[][] matrix, int row, int col) {
        int a = matrix[row][col];
        int b = matrix[row][col + 1];
        int c = matrix[row][col + 2];
        int d = matrix[row + 1][col];
        int e = matrix[row + 1][col + 1];
        int f = matrix[row + 1][col + 2];
        int g = matrix[row + 2][col];
        int h = matrix[row + 2][col + 1];
        int i = matrix[row + 2][col + 2];
        return a + b + c + d + e + f + g + h + i;
    }

    private static void printResult(int[] bestSubMatrixValues) {
        for (int i = 0; i < bestSubMatrixValues.length; i++) {
            System.out.printf("%d ", bestSubMatrixValues[i]);
            if (i == 2 || i == 5) {
                System.out.println();
            }
        }
        System.out.println();
    }

}
