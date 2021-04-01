
// Judge ready

package MultidimentionalArrays.Exercises;

import java.util.Arrays;
import java.util.Scanner;

public class _05_MatrixShuffling {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String[] dimensions = s.nextLine().split("\\s+");
        int rowsCount = Integer.parseInt(dimensions[0]);
        int columnsCount = Integer.parseInt(dimensions[1]);
        String[][] matrix = new String[rowsCount][columnsCount];

        for (int row = 0; row < matrix.length; row++) {
            String[] input = s.nextLine().split("\\s+");

            for (int column = 0; column < matrix[row].length; column++) {
                String current = input[column];
                matrix[row][column] = current;
            }
        }

        while (true) {
            String command = s.nextLine();
            if ("END".equals(command)) {
                break;
            } else {
                String[] tokens = command.split("\\s+");
                boolean isValidCommand = validateCommand(tokens, rowsCount, columnsCount);
                if (!isValidCommand) {
                    System.out.println("Invalid input!");
                } else {
                    swapValues(matrix, tokens);
                    printMatrix(matrix);
                }
            }
        }
    }

    private static boolean validateCommand(String[] tokens, int rowsCount, int columnsCount) {
        String keyword = tokens[0];

        if (!keyword.equals("swap")) {
            return false;
        } else if (!coordinatesCountMatch(tokens)) {
            return false;
        } else if (!ValidCoordinates(tokens, rowsCount, columnsCount)) {
            return false;
        }

        return true;
    }

    private static boolean coordinatesCountMatch(String[] tokens) {
        int count = 0;
        for (String token : tokens) {
            try {
                int probe = Integer.parseInt(token);
                count++;
            } catch (NumberFormatException e) {

            }
        }
        return count == 4;
    }

    private static boolean ValidCoordinates(String[] tokens, int rowsCount, int columnsCount) {
        boolean isValidCoordinate = true;

        for (int i = 0; i < tokens.length; i++) {
            try {
                int coordinateValue = Integer.parseInt(tokens[i]);
                if (i == 1 || i == 3) {
                    if (coordinateValue < 0 || coordinateValue > rowsCount - 1) {
                        isValidCoordinate = false;
                        break;
                    }
                } else if (i == 2 || i == 4) {
                    if (coordinateValue < 0 || coordinateValue > columnsCount - 1) {
                        isValidCoordinate = false;
                        break;
                    }
                }

            } catch (NumberFormatException e) {

            }
        }

        return isValidCoordinate;
    }

    private static void swapValues(String[][] matrix, String[] tokens) {
        int firstRow = Integer.parseInt(tokens[1]);
        int firstColumn = Integer.parseInt(tokens[2]);
        int secondRow = Integer.parseInt(tokens[3]);
        int secondColumn = Integer.parseInt(tokens[4]);
        String temporary = matrix[firstRow][firstColumn];
        matrix[firstRow][firstColumn] = matrix[secondRow][secondColumn];
        matrix[secondRow][secondColumn] = temporary;
    }

    private static void printMatrix(String[][] matrix) {
        for (String[] array : matrix) {
            System.out.println(Arrays.toString(array).replaceAll("[\\[\\],]+", ""));
        }
    }
}
