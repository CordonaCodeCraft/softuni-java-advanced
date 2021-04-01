
// Judge ready

package MultidimentionalArrays.Exercises;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class _06_StringMatrixRotation {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String command = s.nextLine();
        Queue<String> inputs = new LinkedList<>();
        int bestLength = Integer.MIN_VALUE;
        while (true) {
            String input = s.nextLine();
            if ("END".equals(input)) {
                break;
            } else {
                boolean isBestLength = input.length() > bestLength;
                if (isBestLength) {
                    bestLength = input.length();
                }
                inputs.offer(input);
            }
        }
        int rowsCount = inputs.size();
        int columnsCount = bestLength;
        char[][] matrix = new char[rowsCount][columnsCount];
        populateMatrix(matrix, inputs);
        int degrees = extractDegrees(command);
        int patternCode = findPatternCode(degrees);
        printResult(patternCode, matrix);
    }
    
    private static void populateMatrix(char[][] matrix, Queue<String> inputs) {
        StringBuilder extendedInput = new StringBuilder();
        int arrayLength = matrix[0].length;
        int currentRow = 0;
        while (!inputs.isEmpty()) {
            String currentInput = inputs.poll();
            boolean toExtendCurrentInput = currentInput.length() < arrayLength;
            if (toExtendCurrentInput) {
                extendInput(extendedInput, currentInput, arrayLength);
                matrix[currentRow] = extendedInput.toString().toCharArray();
            } else {
                matrix[currentRow] = currentInput.toCharArray();
            }
            currentRow++;
            extendedInput.setLength(0);
        }
    }

    private static void extendInput(StringBuilder extendedInput, String currentInput, int arrayLength) {
        extendedInput.append(currentInput);
        int missingCharactersCount = arrayLength - currentInput.length();
        while (missingCharactersCount >= 1) {
            extendedInput.append(" ");
            missingCharactersCount--;
        }
    }

    private static int extractDegrees(String command) {
        return Integer.parseInt(command.replaceAll("[^\\d]+", ""));
    }

    private static int findPatternCode(int degrees) {
        int degree = 0;
        int printCode = 0;
        while (degree <= degrees) {
            if (degree == degrees) {
                break;
            } else {
                degree += 90;
                printCode++;
            }
            if (printCode == 4) {
                printCode = 0;
            }
        }
        return printCode;
    }

    private static void printResult(int printCode, char[][] matrix) {
        if (printCode == 1) {
            printPattern90(matrix);
        } else if (printCode == 2) {
            printPattern180(matrix);
        } else if (printCode == 3) {
            printPattern270(matrix);
        } else if (printCode == 0) {
            printPattern360(matrix);
        }
    }

    private static void printPattern90(char[][] matrix) {
        // 90 degrees rotation
        int arrayLength = matrix[0].length;
        for (int col = 0; col < arrayLength; col++) {
            for (int row = matrix.length - 1; row >= 0; row--) {
                char currentCharacter = matrix[row][col];
                System.out.print(currentCharacter);
            }
            System.out.println();
        }
    }

    private static void printPattern180(char[][] matrix) {
        // 180 degrees rotation
        int arrayLength = matrix[0].length;
        for (int row = matrix.length - 1; row >= 0; row--) {
            for (int col = arrayLength - 1; col >= 0; col--) {
                char currentCharacter = matrix[row][col];
                System.out.print(currentCharacter);
            }
            System.out.println();
        }
    }

    private static void printPattern270(char[][] matrix) {
        // 270 degrees rotation
        int arrayLength = matrix[0].length;
        for (int col = arrayLength - 1; col >= 0; col--) {
            for (int row = 0; row < matrix.length; row++) {
                char currentCharacter = matrix[row][col];
                System.out.print(currentCharacter);
            }
            System.out.println();

        }

    }

    private static void printPattern360(char[][] matrix) {
        for (char[] chars : matrix) {
            for (char aChar : chars) {
                System.out.print(aChar);
            }
            System.out.println();
        }
    }

}
