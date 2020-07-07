
// TODO: 01.07.2020 г. Judge not ready 80 / 100

package MultidimentionalArrays.Exercises;

import java.util.*;

public class _10_RadioactiveMutantVampireBunnies {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String lairDimensions = s.nextLine();
        int[] dimensions = extractTokens(lairDimensions);
        String[][] lair = generateLair(s, dimensions);
        Deque<Character> directions = feedDirectionsQueue(s);
        String[] playerStatus = new String[3];

        boolean gameOver = false;

        while (!gameOver) {
            char playerDirection = directions.remove();

            movePlayer(lair, playerDirection, playerStatus);

            spreadBunnies(lair, playerStatus);

            if (playerStatus[2].equals("won") || playerStatus[2].equals("dead")) {
                gameOver = true;
            }
        }

        printLair(lair);

        System.out.printf("%s: %d %d", playerStatus[2], Integer.parseInt(playerStatus[0]), Integer.parseInt(playerStatus[1]));
    }


    private static int[] extractTokens(String input) {
        return Arrays
                .stream(input.split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
    }

    private static String[][] generateLair(Scanner s, int[] dimensions) {
        int rows = dimensions[0];
        int columns = dimensions[1];
        String[][] lair = new String[rows][columns];


        for (int row = 0; row < lair.length; row++) {
            lair[row] = s.nextLine().split("");
        }

        return lair;
    }

    private static Deque<Character> feedDirectionsQueue(Scanner s) {
        Deque<Character> directions = new ArrayDeque<>();
        char[] instructions = s.nextLine().toCharArray();

        for (char direction : instructions) {
            directions.offer(direction);
        }

        return directions;
    }

    private static void movePlayer(String[][] lair, char playerDirection, String[] playerStatus) {

        int currentRow = 0;
        int currentColumn = 0;

        for (int thisRow = 0; thisRow < lair.length; thisRow++) {
            boolean playerFound = Arrays.asList(lair[thisRow]).contains("P");
            if (playerFound) {
                currentRow = thisRow;
                currentColumn = Arrays.asList(lair[thisRow]).indexOf("P");
                lair[thisRow][currentColumn] = ".";
                break;
            }
        }

        int nextRow = 0;
        int nextColumn = 0;

        switch (playerDirection) {
            case 'U':
                nextRow = currentRow - 1;
                nextColumn = currentColumn;
                break;

            case 'D':
                nextRow = currentRow + 1;
                nextColumn = currentColumn;
                break;

            case 'L':
               nextColumn = currentColumn - 1;
               nextRow = currentRow;
                break;

            case 'R':
                nextColumn = currentColumn + 1;
                nextRow = currentRow;
                break;
        }

        boolean playerWins = (nextRow < 0 || nextRow == lair.length) || (nextColumn < 0 || nextColumn == lair[0].length);

        if (playerWins) {
            playerStatus[0] = String.valueOf(currentRow);
            playerStatus[1] = String.valueOf(currentColumn);
            playerStatus[2] = "won";
        } else {
            if (lair[nextRow][nextColumn].equals("B")) {
                playerStatus[0] = String.valueOf(nextRow);
                playerStatus[1] = String.valueOf(nextColumn);
                playerStatus[2] = "dead";
            } else {
                lair[nextRow][nextColumn] = "P";
                playerStatus[2] = "continue";
            }
        }
    }

    private static void spreadBunnies(String[][] lair, String[] playerStatus) {

        Map<Integer, Deque<Integer>> bunniesMap = new LinkedHashMap<>();

        for (int thisRow = 0; thisRow < lair.length; thisRow++) {
            for (int thisColumn = 0; thisColumn < lair[0].length; thisColumn++) {
                boolean bunnieLocated = lair[thisRow][thisColumn].equals("B");
                if (bunnieLocated) {
                    Deque<Integer> bunniesOnThisRow = new ArrayDeque<>();
                    bunniesMap.putIfAbsent(thisRow, bunniesOnThisRow);
                    bunniesMap.get(thisRow).offer(thisColumn);
                }
            }
        }

        for (Integer thisRow : bunniesMap.keySet()) {

            while (!bunniesMap.get(thisRow).isEmpty()) {
                int thisColumn = bunniesMap.get(thisRow).remove();
                boolean canSpreadUp = thisRow - 1 >= 0;
                boolean canSpreadDown = thisRow + 1 <= lair.length - 1;
                boolean canSpreadLeft = thisColumn - 1 >= 0;
                boolean canSpreadRight = thisColumn + 1 <= lair[0].length - 1;

                if (canSpreadUp) {
                    if (lair[thisRow - 1][thisColumn].equals("P")) {
                        playerStatus[0] = String.valueOf(thisRow - 1);
                        playerStatus[1] = String.valueOf(thisColumn);
                        playerStatus[2] = "dead";
                    } else {
                        lair[thisRow - 1][thisColumn] = "B";
                    }
                }

                if (canSpreadDown) {
                    if (lair[thisRow + 1][thisColumn].equals("P")) {
                        playerStatus[0] = String.valueOf(thisRow + 1);
                        playerStatus[1] = String.valueOf(thisColumn);
                        playerStatus[2] = "dead";
                    } else {
                        lair[thisRow + 1][thisColumn] = "B";
                    }
                }

                if (canSpreadLeft) {
                    if (lair[thisRow][thisColumn - 1].equals("P")) {
                        playerStatus[0] = String.valueOf(thisRow);
                        playerStatus[1] = String.valueOf(thisColumn - 1);
                        playerStatus[2] = "dead";
                    } else {
                        lair[thisRow][thisColumn - 1] = "B";
                    }
                }

                if (canSpreadRight) {
                    if (lair[thisRow][thisColumn + 1].equals("P")) {
                        playerStatus[0] = String.valueOf(thisRow);
                        playerStatus[1] = String.valueOf(thisColumn + 1);
                        playerStatus[2] = "dead";
                    } else {
                        lair[thisRow][thisColumn + 1] = "B";
                    }
                }
            }
        }
    }

    private static void printLair(String[][] lair) {
        for (String[] row : lair) {
            System.out.println(Arrays.toString(row).replaceAll("[\\[\\],\\s]", " "));
        }
    }
}
