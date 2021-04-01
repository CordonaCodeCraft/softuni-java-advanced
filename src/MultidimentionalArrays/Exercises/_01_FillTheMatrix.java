// Judge ready

package MultidimentionalArrays.Exercises;

import java.util.Scanner;

public class _01_FillTheMatrix {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String[] input = s.nextLine().split(", ");
        int dimensions = Integer.parseInt(input[0]);
        String method = input[1];
        int[][] matrix = new int[dimensions][dimensions];
        int digit = 1;

        if (method.equals("A")) {
            for (int col = 0; col < dimensions; col++) {
                digit = increaseFromTopToBottom(matrix, dimensions, col, digit);
            }
        } else {
            for (int col = 0; col < dimensions; col++) {
                if (col % 2 == 0) {
                    digit = increaseFromTopToBottom(matrix, dimensions, col, digit);
                } else {
                    digit = increaseFromBottomToTop(matrix, dimensions, col, digit);
                }
            }
        }
        printMatrix(matrix);
    }

    private static int increaseFromTopToBottom(int[][] matrix, int dimensions, int col, int digit) {
        for (int row = 0; row < dimensions; row++) {
            matrix[row][col] = digit;
            digit++;
        }
        return digit;
    }

    private static int increaseFromBottomToTop(int[][] matrix, int dimensions, int col, int digit) {
        for (int row = dimensions - 1; row >= 0; row--) {
            matrix[row][col] = digit;
            digit++;
        }
        return digit;
    }

    private static void printMatrix(int[][] matrix) {
        for (int[] array : matrix) {
            for (int integer : array) {
                System.out.printf("%d ", integer);
            }
            System.out.println();
        }
    }
}