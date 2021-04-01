package LinearDataStructures.Lab;

import java.util.Scanner;

public class _04_MaximumSumOf2x2Submatrix {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String[] dimensions = s.nextLine().split(", ");
        int rows = Integer.parseInt(dimensions[0]);
        int cols = Integer.parseInt(dimensions[1]);
        int[][] matrix = new int[rows][cols];

        populateMatrix(matrix, s);

        int bestSum = Integer.MIN_VALUE;
        int[] bestSubMatrixValues = new int[4];

        for (int row = 0; row < matrix.length - 1; row++) {

            for (int col = 0; col < matrix[row].length - 1; col++) {
                int currentSum = calculateCurrentSum(matrix, row, col);
                if (currentSum > bestSum) {
                    bestSum = currentSum;
                    bestSubMatrixValues[0] = matrix[row][col];
                    bestSubMatrixValues[1] = matrix[row][col + 1];
                    bestSubMatrixValues[2] = matrix[row + 1][col];
                    bestSubMatrixValues[3] = matrix[row + 1][col + 1];
                }
            }

        }

        printResult(bestSubMatrixValues, bestSum);

    }

    private static void populateMatrix(int[][] matrix, Scanner s) {
        for (int row = 0; row < matrix.length; row++) {
            String[] input = s.nextLine().split(", ");
            for (int column = 0; column < matrix[row].length; column++) {
                int currentDigit = Integer.parseInt(input[column]);
                matrix[row][column] = currentDigit;
            }
        }
    }

    private static int calculateCurrentSum(int[][] matrix, int row, int col) {
        int a = matrix[row][col];
        int b = matrix[row][col + 1];
        int c = matrix[row + 1][col];
        int d = matrix[row + 1][col + 1];
        return a + b + c + d;
    }

    private static void printResult(int[] bestSubMatrixValues, int bestSum) {
        for (int i = 0; i < bestSubMatrixValues.length; i++) {
            System.out.printf("%d ", bestSubMatrixValues[i]);
            if (i == 1) {
                System.out.println();
            }
        }
        System.out.println();
        System.out.print(bestSum);

    }
}
