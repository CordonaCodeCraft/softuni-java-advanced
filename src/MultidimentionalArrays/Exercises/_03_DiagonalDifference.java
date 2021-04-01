package MultidimentionalArrays.Exercises;

import java.util.Scanner;

public class _03_DiagonalDifference {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int size = Integer.parseInt(s.nextLine());
        int[][] matrix = new int[size][size];

        for (int row = 0; row < size; row++) {
            String[] tokens = s.nextLine().split("\\s+");
            for (int column = 0; column < size; column++) {
                matrix[row][column] = Integer.parseInt(tokens[column]);
            }
        }

        int leftDiagonal = calculateLeftDiagonal(matrix, size);
        int rightDiagonal = calculateRightDiagonal(matrix, size);
        int result = Math.abs(leftDiagonal - rightDiagonal);

        System.out.println(result);
    }

    private static int calculateLeftDiagonal(int[][] matrix, int size) {
        int leftDiagonal = 0;
        int targetColumn = 0;

        for (int row = 0; row < size; row++) {
            leftDiagonal += matrix[row][targetColumn];
            targetColumn++;
        }
        return leftDiagonal;
    }

    private static int calculateRightDiagonal(int[][] matrix, int size) {
        int rightDiagonal = 0;
        int targetColumn = matrix.length - 1;

        for (int row = 0; row < size; row++) {
            rightDiagonal += matrix[row][targetColumn];
            targetColumn--;
        }
        return rightDiagonal;
    }
}
