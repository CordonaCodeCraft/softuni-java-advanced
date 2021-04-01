
// Judge ready

package SetsAndMaps.Exercises;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class _01_UniqueUsernames {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int usersCount = Integer.parseInt(s.nextLine());
        Set<String> userNames = generateUserNames(s,usersCount);
        printUserNames(userNames);

        
    }

    private static Set<String> generateUserNames(Scanner s, int usersCount) {
        Set<String> userNames = new LinkedHashSet<>();

        for (int i = 0; i < usersCount; i++) {
            userNames.add(s.nextLine());
        }

        return userNames;
    }

    private static void printUserNames(Set<String> userNames) {
        for (String userName : userNames) {
            System.out.printf("%s%n", userName);
        }

    }
}
