
// Judge ready

package MultidimentionalArrays.Exercises;

import java.util.Scanner;

public class _02_MatrixOfPalindromes {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        String[] dimensions = s.nextLine().split("\\s+");
        int rowsCount = Integer.parseInt(dimensions[0]);
        int columnsCount = Integer.parseInt(dimensions[1]);
        String[][] matrix = new String[rowsCount][columnsCount];
        int alphabetStartIndex = 0;

        for (int row = 0; row < rowsCount; row++) {
            char firstAndLastLetter = alphabet[row];
            for (int column = 0; column < columnsCount; column++) {
                char middleLetter = alphabet[alphabetStartIndex + column];
                String palindrome = generatePalindrome(firstAndLastLetter, middleLetter);
                matrix[row][column] = palindrome;
            }
            alphabetStartIndex++;
        }
        printMatrix(matrix);
    }

    private static String generatePalindrome(char firstAndLastLetter, char middleLetter) {
        StringBuilder palindrome = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            if (i == 1) {
                palindrome.append(middleLetter);
            } else {
                palindrome.append(firstAndLastLetter);
            }
        }
        return palindrome.toString();
    }

    private static void printMatrix(String[][] matrix) {
        for (String[] palindromes : matrix) {
            System.out.println(String.join(" ", palindromes));
        }
    }
}
