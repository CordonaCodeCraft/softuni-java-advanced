
// Judge ready

package MultidimentionalArrays.Lab;

import java.util.Scanner;

public class _03_IntersectionOfTwoMatrices {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        StringBuilder result = new StringBuilder();
        int rows = Integer.parseInt(s.nextLine());
        int columns = Integer.parseInt(s.nextLine());
        char[][][] cube = new char[2][rows][columns];
        char[][] product = new char[rows][columns];

        for (char[][] matrix : cube) {
            for (int row = 0; row < rows; row++) {
                matrix[row] = generateMatrixRow(s.nextLine());
            }
        }

        for (int row = 0; row < rows; row++) {
            for (int column = 0; column < columns; column++) {
                char leftCharacter = cube[0][row][column];
                char rightCharacter = cube[1][row][column];
                boolean charactersIntersect = leftCharacter == rightCharacter;
                if (charactersIntersect) {
                    product[row][column] = leftCharacter;
                } else {
                    product[row][column] = '*';
                }
            }
        }

        generateResult(product, result);
        System.out.println(result);
}

    private static char[] generateMatrixRow(String nextLine) {
        String[] tokens = nextLine.split(" ");
        char[] matrixRow = new char[tokens.length];
        for (int i = 0; i < tokens.length; i++) {
            char currentCharacter = tokens[i].charAt(0);
            matrixRow[i] = currentCharacter;
        }
        return matrixRow;
    }

    private static void generateResult(char[][] product, StringBuilder result) {
        for (char[] row : product) {
            for (char character : row) {
                result.append(String.format("%c ", character));
            }
            result.append(System.lineSeparator());
        }
    }
}

