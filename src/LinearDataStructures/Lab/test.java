package LinearDataStructures.Lab;

import java.util.Scanner;

public class test {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int num = Integer.parseInt(s.nextLine());
        boolean isPrime = validatePrimeNumber(num);
        System.out.println(isPrime);
    }

    private static boolean validatePrimeNumber(int num) {
        if (num % 2 == 0) return false;
        for (int i = 3; i * i <= num; i += 2) {
            if (num % i == 0)
                return false;
        }
        return true;
    }
}
