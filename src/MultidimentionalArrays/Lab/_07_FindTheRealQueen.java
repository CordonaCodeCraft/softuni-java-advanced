package MultidimentionalArrays.Lab;

import java.util.Scanner;

public class _07_FindTheRealQueen {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        char[][] chessBoard = generateChessBoard(s);

        for (int row = 0; row < chessBoard.length; row++) {
            int[] queensTokens = traverseCurrentRowForQueens(chessBoard[row]);
            int queensCount = queensTokens[0];
            if (queensCount == 1) {
                int queenPosition = queensTokens[1];
                boolean foundTheRealQueen = initializeChessboardScan(chessBoard, row, queenPosition);
                if (foundTheRealQueen) {
                    System.out.printf("%d %d%n", row, queenPosition);
                    break;
                }
            }
        }
    }

    private static char[][] generateChessBoard(Scanner s) {
        char[][] chessBoard = new char[8][8];
        for (int i = 0; i < chessBoard.length; i++) {
            chessBoard[i] = generateRow(s.nextLine()).clone();

        }
        return chessBoard;
    }

    private static char[] generateRow(String nextLine) {
        char[] row = new char[8];
        String[] tokens = nextLine.split(" ");
        for (int i = 0; i < tokens.length; i++) {
            char character = tokens[i].charAt(0);
            row[i] = character;
        }
        return row;
    }

    private static int[] traverseCurrentRowForQueens(char[] row) {
        int[] tokens = new int[2];

        for (int column = 0; column < row.length; column++) {
            char currentCharacter = row[column];
            if (currentCharacter == 'q') {
                tokens[0]++;
                tokens[1] = column;
            }
        }
        return tokens;
    }

    private static boolean initializeChessboardScan(char[][] chessBoard, int row, int queenPosition) {
        boolean foundTheRealQueen = true;
        boolean isFirstRow = row == 0;
        boolean isLastRow = row == chessBoard.length - 1;

        if (isFirstRow) {
            boolean queenDetected = traverseFromTopToBottom(chessBoard, row, queenPosition);
            if (queenDetected) {
                foundTheRealQueen = false;
            }
        } else if (isLastRow) {
            boolean queenDetected = traverseFromBottomToTop(chessBoard, row, queenPosition);
            if (queenDetected) {
                foundTheRealQueen = false;
            }
        } else {
            boolean queenDetected = traverseFromTopToBottom(chessBoard, row, queenPosition);
            if (queenDetected) {
                foundTheRealQueen = false;
            } else {
                queenDetected = traverseFromBottomToTop(chessBoard, row, queenPosition);
                if (queenDetected) {
                    foundTheRealQueen = false;
                }
            }
        }
        return foundTheRealQueen;
    }

    private static boolean traverseFromTopToBottom(char[][] chessBoard, int row, int queenIndex) {
        boolean QueenDetected = false;
        int offsetIndex = 1;
        for (int currentRow = row + 1; currentRow < chessBoard.length; currentRow++) {
            int leftDiagonalIndex = queenIndex - offsetIndex;
            int rightDiagonalIndex = queenIndex + offsetIndex;
            boolean queenDetected = detectQueens(chessBoard, currentRow, leftDiagonalIndex, rightDiagonalIndex, queenIndex);
            if (queenDetected) {
                QueenDetected = true;
                break;
            } else {
                offsetIndex++;
            }
        }
        return QueenDetected;
    }

    private static boolean traverseFromBottomToTop(char[][] chessBoard, int row, int queenIndex) {
        boolean QueenDetected = false;
        int offsetIndex = 1;
        for (int currentRow = row - 1; currentRow >= 0; currentRow--) {
            int leftDiagonalIndex = queenIndex - offsetIndex;
            int rightDiagonalIndex = queenIndex + offsetIndex;
            boolean queenDetected = detectQueens(chessBoard, currentRow, leftDiagonalIndex, rightDiagonalIndex, queenIndex);
            if (queenDetected) {
                QueenDetected = true;
                break;
            } else {
                offsetIndex++;
            }
        }
        return QueenDetected;
    }

    private static boolean detectQueens(char[][] chessBoard, int row, int leftDiagonalIndex, int rightDiagonalIndex, int queenIndex) {
        boolean queenDetected = false;
        boolean leftDiagonalIndexInRange = leftDiagonalIndex >= 0;
        boolean rightDiagonalIndexInRange = rightDiagonalIndex <= chessBoard.length - 1;
        if (rightDiagonalIndexInRange && leftDiagonalIndexInRange) {
            queenDetected = chessBoard[row][queenIndex] == 'q'
                    || chessBoard[row][leftDiagonalIndex] == 'q'
                    || chessBoard[row][rightDiagonalIndex] == 'q';
        } else if (!leftDiagonalIndexInRange && rightDiagonalIndexInRange) {
            queenDetected = chessBoard[row][queenIndex] == 'q'
                    || chessBoard[row][rightDiagonalIndex] == 'q';
        } else if (!rightDiagonalIndexInRange && leftDiagonalIndexInRange) {
            queenDetected = chessBoard[row][queenIndex] == 'q'
                    || chessBoard[row][leftDiagonalIndex] == 'q';
        }

        return queenDetected;
    }
}
