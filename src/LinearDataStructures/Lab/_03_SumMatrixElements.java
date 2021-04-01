
// Judge ready

package LinearDataStructures.Lab;

import java.util.Arrays;
import java.util.Scanner;

public class _03_SumMatrixElements {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String[] dimensions = s.nextLine().split(", ");
        int rows = Integer.parseInt(dimensions[0]);
        int cols = Integer.parseInt(dimensions[1]);
        int[][] matrix = new int[rows][cols];
        populateMatrix(matrix, s);
        int sumOfMatrixElements = calculateSum(matrix);
        System.out.printf("%d%n%d%n%d",rows,cols,sumOfMatrixElements);
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

    private static int calculateSum(int[][] matrix) {
        int sum = 0;
        for (int[] row : matrix) {
            sum += Arrays
                    .stream(row)
                    .sum();
        }
        return  sum;
    }
}
