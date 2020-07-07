// TODO: 30.06.2020 г. Judge not ready 90/100

package MultidimentionalArrays.Exercises;

import java.util.*;

public class _09_ParkingSystem {
    public static void main(String[] args) {
        Map<Integer, List<Integer>> occupiedLots = new HashMap<>();
        StringBuilder product = new StringBuilder();
        Scanner s = new Scanner(System.in);
        String parkingDimensions = s.nextLine();
        int[] dimensions = extractTokens(parkingDimensions);
        int parkingLotColumns = dimensions[1];

        while (true) {
            String command = s.nextLine();
            if ("stop".equals(command)) {
                break;
            } else {
                int[] targetLotCoordinates = extractTokens(command);
                int entranceRow = targetLotCoordinates[0];
                int targetRow = targetLotCoordinates[1];
                int targetColumn = targetLotCoordinates[2];

                saveTargetRow(occupiedLots, targetRow);

                if (targetRowHasFreeLots(occupiedLots, targetRow, parkingLotColumns)) {
                    int validLot = findValidLot(parkingLotColumns, occupiedLots, targetRow, targetColumn);
                    int distance = calculateDistance(entranceRow, targetRow, validLot);

                    product
                            .append(distance)
                            .append(System.lineSeparator());

                    occupiedLots.get(targetRow).add(validLot);
                } else {
                    product
                            .append(String.format("Row %d full", targetRow))
                            .append(System.lineSeparator());
                }
            }
        }

        System.out.println(product);
    }

    private static int[] extractTokens(String input) {
        return Arrays
                .stream(input.split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
    }

    private static void saveTargetRow(Map<Integer, List<Integer>> occupiedLots, int targetRow) {
        List<Integer> occupied = new ArrayList<>();
        occupiedLots.putIfAbsent(targetRow, occupied);
    }

    private static boolean targetRowHasFreeLots(Map<Integer, List<Integer>> occupiedLots, int targetRow, int parkingLotColumns) {
        return occupiedLots.get(targetRow).size() != parkingLotColumns - 1;
    }

    private static int findValidLot(int parkingLotColumns, Map<Integer, List<Integer>> occupiedLots, int targetRow, int targetColumn) {
        int actualLot = targetColumn;

        boolean targetColumnIsNotFree = occupiedLots.get(targetRow).contains(targetColumn);
        boolean leftColumnIsFree = targetColumn - 1 != 0 && !occupiedLots.get(targetRow).contains(targetColumn - 1);
        boolean rightColumnIsFree = targetColumn + 1 <= parkingLotColumns - 1 && !occupiedLots.get(targetRow).contains(targetColumn + 1);

        if (targetColumnIsNotFree) {
            if (leftColumnIsFree) {
                actualLot = targetColumn - 1;
            } else if (rightColumnIsFree) {
                actualLot = targetColumn + 1;
            } else {
                Collections.sort(occupiedLots.get(targetRow));
                int actualValue = occupiedLots.get(targetRow).get(0) - 1;
                if (actualValue <= 0) {
                    int targetRowLastIndex = occupiedLots.get(targetRow).size() - 1;
                    actualValue = occupiedLots.get(targetRow).get(targetRowLastIndex) + 1;
                }

                actualLot = actualValue;
            }
        }


        return actualLot;
    }

    private static int calculateDistance(int entranceRow, int targetRow, int validLot) {

        int columnDistance = Math.abs(entranceRow - targetRow) + 1;

        int rowDistance = 0;

        while (validLot-- >= 1) {
            rowDistance++;
        }

        return columnDistance + rowDistance;
    }

}
