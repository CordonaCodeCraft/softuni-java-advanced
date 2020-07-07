
// TODO: 28.06.2020 г. Judge not ready 80 / 100. Entirely wrong approach. To be solved with jagged matrix

package MultidimentionalArrays.Exercises;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class _07_Crossfire {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        StringBuilder product = new StringBuilder();
        String input = s.nextLine();
        int[] dimensions = extractTokens(input);
        String[][] matrix = generateMatrix(dimensions);

        while (true) {
            input = s.nextLine();
            if ("Nuke it from orbit".equals(input)) {
                break;
            } else {
                int[] targetParameters = extractTokens(input);
                initializeDemolitionSequence(matrix, targetParameters);
            }
        }

        generateProduct(matrix, product);
        System.out.println(product);

    }

    private static int[] extractTokens(String input) {
        return Arrays
                .stream(input.split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
    }

    private static String[][] generateMatrix(int[] dimensions) {
        int rows = dimensions[0];
        int columns = dimensions[1];
        int counter = 1;

        String[][] matrix = new String[rows][columns];

        for (int row = 0; row < rows; row++) {
            for (int column = 0; column < columns; column++) {
                String value = String.valueOf(counter++);
                matrix[row][column] = value;
            }
        }
        return matrix;
    }

    private static void initializeDemolitionSequence(String[][] matrix, int[] targetParameters) {

        String[] targetReport = analyzeTargetCoordinates(matrix, targetParameters);
        String location = targetReport[0];
        String damageReport = targetReport[1];

        switch (location) {
            case "Target is inside the matrix":
                modifyMatrix(matrix, targetParameters);
                break;
            case "Only row is in bounds":
                if (damageReport.equals("Explosion will affect target row")) {
                    modifyTargetRow(matrix, targetParameters);
                    break;
                }
            case "Only column is in bounds":
                if (damageReport.equals("Explosion will affect column(s)")) {
                    modifyColumns(matrix, targetParameters);
                    break;
                }
        }
    }

    private static String[] analyzeTargetCoordinates(String[][] matrix, int[] targetParameters) {
        String[] reportTargetCoordinates = new String[2];

        int targetRow = targetParameters[0];
        int targetColumn = targetParameters[1];
        int explosionRadius = targetParameters[2];

        int rowsCount = matrix.length - 1;
        int rowsLength = matrix[0].length - 1;

        boolean targetRowInBounds = targetRow >= 0 && targetRow <= rowsCount;
        boolean targetColumnInBounds = targetColumn >= 0 && targetColumn <= rowsLength;
        boolean targetIsInsideTheMatrix = targetRowInBounds && targetColumnInBounds;
        boolean onlyRowInBound = targetRowInBounds && !targetColumnInBounds;
        boolean onlyColumnInBound = targetColumnInBounds && !targetRowInBounds;

        if (targetIsInsideTheMatrix) {
            reportTargetCoordinates[0] = "Target is inside the matrix";
        } else if (onlyRowInBound) {
            reportTargetCoordinates[0] = "Only row is in bounds";
            if (targetColumn < 0 && targetColumn + explosionRadius >= 0) {
                reportTargetCoordinates[1] = "Explosion will affect target row";
            } else if (targetColumn > rowsLength && targetColumn - explosionRadius <= rowsLength) {
                reportTargetCoordinates[1] = "Explosion will affect target row";
            } else {
                reportTargetCoordinates[1] = "Explosion will not affect target row";
            }
        } else if (onlyColumnInBound) {
            reportTargetCoordinates[0] = "Only column is in bounds";
            if (targetRow < 0 && targetRow + explosionRadius >= 0) {
                reportTargetCoordinates[1] = "Explosion will affect column(s)";
            } else if (targetRow > rowsCount && targetRow - explosionRadius <= rowsCount) {
                reportTargetCoordinates[1] = "Explosion will affect column(s)";
            } else {
                reportTargetCoordinates[1] = "Explosion will not affect column(s)";
            }
        } else {
            reportTargetCoordinates[0] = "Explosion will not affect the matrix";

        }

        return reportTargetCoordinates;

    }

    private static void modifyMatrix(String[][] matrix, int[] targetParameters) {
        int targetRow = targetParameters[0];
        int targetColumn = targetParameters[1];
        int explosionRadius = targetParameters[2];

        int rowsCount = matrix.length - 1;
        int rowsLength = matrix[0].length - 1;

        int firstAffectedRow = Math.max(targetRow - explosionRadius, 0);
        int lastAffectedRow = Math.min(targetRow + explosionRadius, rowsCount);


        for (int row = firstAffectedRow; row <= lastAffectedRow; row++) {
            int firstAffectedIndex = targetColumn;
            int lastAffectedIndex = targetColumn;

            if (row == targetRow) {
                firstAffectedIndex = Math.max(targetColumn - explosionRadius, 0);
                lastAffectedIndex = Math.min(targetColumn + explosionRadius, rowsLength);
            }

            modifyRow(matrix, row, firstAffectedIndex, lastAffectedIndex, rowsLength);

        }
    }

    private static void modifyTargetRow(String[][] matrix, int[] targetParameters) {

        int targetRow = targetParameters[0];
        int targetColumn = targetParameters[1];
        int explosionRadius = targetParameters[2];
        int rowsLength = matrix[0].length - 1;

        boolean leftExplosion = targetColumn < 0;
        boolean rightExplosion = targetColumn > rowsLength;

        int firstAffectedIndex = Math.max(targetColumn - explosionRadius, 0);
        int lastAffectedIndex = Math.min(targetColumn + explosionRadius, rowsLength);

        if (leftExplosion) {
            firstAffectedIndex = 0;
        } else if (rightExplosion) {
            lastAffectedIndex = rowsLength;
        }

        modifyRow(matrix, targetRow, firstAffectedIndex, lastAffectedIndex, rowsLength);

    }

    private static void modifyRow(String[][] matrix, int row, int firstAffectedIndex, int lastAffectedIndex, int rowsLength) {

        List<String> product = new ArrayList<>(Arrays.asList(matrix[row]));
        product.subList(firstAffectedIndex, lastAffectedIndex + 1).clear();

        if (product.isEmpty()) {
            matrix = rebuildMatrix(matrix, row);
        } else {
            Deque<String> queue = new ArrayDeque<>(product);
            for (int column = 0; column <= rowsLength; column++) {
                while (!queue.isEmpty()) {
                    matrix[row][column++] = queue.poll();
                }
                matrix[row][column] = " ";
            }
        }
    }

    private static String[][] rebuildMatrix(String[][] matrix, int row) {
        int newMatrixSize = matrix.length - 1;
        int rowsLength = matrix[0].length;
        int newMatrixRow = 0;
        String[][] newMatrix = new String[newMatrixSize][rowsLength];
        for (int currentRow = 0; currentRow < matrix.length; currentRow++) {
            if (currentRow != row) {
                newMatrix[newMatrixRow++] = matrix[currentRow].clone();
            }
        }
        return newMatrix;
    }

    private static void modifyColumns(String[][] matrix, int[] targetParameters) {

        int targetRow = targetParameters[0];
        int targetColumn = targetParameters[1];
        int explosionRadius = targetParameters[2];

        int rowsCount = matrix.length - 1;
        int rowsLength = matrix[0].length - 1;

        boolean explosionFromBottom = targetRow > rowsCount;

        int firstAffectedRow = 0;
        int lastAffectedRow = Math.min(targetRow + explosionRadius, rowsCount);

        if (explosionFromBottom) {
            firstAffectedRow = Math.max(targetRow - explosionRadius, 0);
            lastAffectedRow = rowsCount;
        }

        for (int row = firstAffectedRow; row <= lastAffectedRow; row++) {
            modifyRow(matrix, row, targetColumn, targetColumn, rowsLength);
        }
    }

    private static void generateProduct(String[][] matrix, StringBuilder product) {
        for (String[] row : matrix) {
            String currentRow = Arrays.toString(row).replaceAll("[\\[\\],]", "");

            Pattern pattern = Pattern.compile("[0-9]");
            Matcher matcher = pattern.matcher(currentRow);

            if (matcher.find()) {
                product
                        .append(currentRow)
                        .append(System.lineSeparator());
            }
        }
    }
}
