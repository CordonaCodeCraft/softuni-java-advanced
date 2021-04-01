package LinearDataStructures.Lab;

import java.util.Scanner;

public class test2 {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int cycle = Integer.parseInt(s.nextLine());
        boolean isPrime = validatePrimeCycle(cycle);
        System.out.println(isPrime);

    }

    private static boolean validatePrimeCycle(int cycle) {
        boolean isPrime = true;
        if (cycle == 1) {
            isPrime = false;
        } else {
            for (int i = 2; i <= cycle / 2; ++i) {
                if (cycle % i == 0) {
                    isPrime = false;
                    break;
                }
            }
        }
        return isPrime;
    }
}