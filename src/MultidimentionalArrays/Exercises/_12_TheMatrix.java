package MultidimentionalArrays.Exercises;

import java.util.*;

public class _12_TheMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Deque<Integer> tracePath = new ArrayDeque<>();

        char[][] matrix = generateMatrix(scanner);
        char fillingCharacter = scanner.nextLine().charAt(0);
        int[] startingCoordinates = extractTokens(scanner);

        int pathRow = startingCoordinates[0];
        int pathColumn = startingCoordinates[1];

        char tracingCharacter = matrix[pathRow][pathColumn];

        matrix[pathRow][pathColumn] = fillingCharacter;

        addThisCharacterToTracePath(pathRow, pathColumn, tracePath);

        followNextTracingCharacter(matrix, tracePath, tracingCharacter, fillingCharacter, pathRow, pathColumn);

        printMatrix(matrix);

    }

    private static void followNextTracingCharacter(char[][] matrix, Deque<Integer> tracePath, char tracingCharacter, char fillingCharacter, int pathRow, int pathColumn) {

        boolean canMoveUp = pathRow - 1 >= 0 && matrix[pathRow - 1][pathColumn] == tracingCharacter;
        boolean canMoveDown = pathRow + 1 < matrix.length && matrix[pathRow + 1][pathColumn] == tracingCharacter;
        boolean canMoveLeft = pathColumn - 1 >= 0 && matrix[pathRow][pathColumn - 1] == tracingCharacter;
        boolean canMoveRight = pathColumn + 1 < matrix[0].length && matrix[pathRow][pathColumn + 1] == tracingCharacter;

        if (canMoveUp) {
            while (--pathRow >= 0 && matrix[pathRow][pathColumn] == tracingCharacter) {

                changeThisCharacterToFillingCharacter(matrix, pathRow, pathColumn, fillingCharacter);

                addThisCharacterToTracePath(pathRow, pathColumn, tracePath);
            }

            pathRow += 1;

        } else if (canMoveRight) {
            while (++pathColumn < matrix[0].length && matrix[pathRow][pathColumn] == tracingCharacter) {

                changeThisCharacterToFillingCharacter(matrix, pathRow, pathColumn, fillingCharacter);

                addThisCharacterToTracePath(pathRow, pathColumn, tracePath);
            }

            pathColumn -= 1;

        } else if (canMoveDown) {
            while (++pathRow < matrix.length && matrix[pathRow][pathColumn] == tracingCharacter) {

                changeThisCharacterToFillingCharacter(matrix, pathRow, pathColumn, fillingCharacter);

                addThisCharacterToTracePath(pathRow, pathColumn, tracePath);
            }

            pathRow -= 1;

        } else if (canMoveLeft) {
            while (--pathColumn >= 0 && matrix[pathRow][pathColumn] == tracingCharacter) {

                changeThisCharacterToFillingCharacter(matrix, pathRow, pathColumn, fillingCharacter);

                addThisCharacterToTracePath(pathRow, pathColumn, tracePath);
            }

            pathColumn += 1;

        } else {
            try {
                removeDeadEndCharacterFromPath(tracePath);

                pathRow = stepBack(tracePath);
                pathColumn = stepBack(tracePath);

                addThisCharacterToTracePath(pathRow, pathColumn, tracePath);


            } catch (NoSuchElementException e) {
                return;
            }

            followNextTracingCharacter(matrix, tracePath, tracingCharacter, fillingCharacter, pathRow, pathColumn);
        }

        followNextTracingCharacter(matrix, tracePath, tracingCharacter, fillingCharacter, pathRow, pathColumn);


    }

    private static int[] extractTokens(Scanner s) {
        return Arrays
                .stream(s.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
    }

    private static char[][] generateMatrix(Scanner scanner) {
        int[] dimensions = extractTokens(scanner);
        int rows = dimensions[0];
        int columns = dimensions[1];

        char[][] matrix = new char[rows][columns];

        for (int row = 0; row < rows; row++) {
            matrix[row] = scanner
                    .nextLine()
                    .replaceAll(" ", "")
                    .toCharArray();
        }

        return matrix;
    }

    private static void changeThisCharacterToFillingCharacter(char[][] matrix, int pathRow, int pathColumn, char fillingCharacter) {
        matrix[pathRow][pathColumn] = fillingCharacter;
    }

    private static void addThisCharacterToTracePath(int pathRow, int pathColumn, Deque<Integer> tracePath) {
        tracePath.push(pathColumn);
        tracePath.push(pathRow);
    }

    private static void removeDeadEndCharacterFromPath(Deque<Integer> tracePath) {
        tracePath.pop();
        tracePath.pop();
    }

    private static int stepBack(Deque<Integer> tracePath) {
        return tracePath.pop();

    }

    private static void printMatrix(char[][] matrix) {

        for (char[] row : matrix) {
            System.out.println(Arrays.toString(row).replaceAll("[\\[\\],\\s]", ""));
        }

    }
}
