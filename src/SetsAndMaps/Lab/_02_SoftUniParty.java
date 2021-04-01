
// Judge ready

package SetsAndMaps.Lab;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class _02_SoftUniParty {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        Set<String> vipGuests = new TreeSet<>();
        Set<String> regularGuests = new TreeSet<>();

        feedGuestLists(s, vipGuests, regularGuests);

        removeArrivedGuestsFromLists(s,vipGuests,regularGuests);

        printMissingGuests(vipGuests,regularGuests);
        
    }

    private static void feedGuestLists(Scanner s, Set<String> vipGuests, Set<String> regularGuests) {
        while (true) {
            String input = s.nextLine();
            if ("PARTY".equals(input)) {
                break;
            } else {
                boolean isVIPGuest = Character.isDigit(input.charAt(0));
                if (isVIPGuest) {
                    vipGuests.add(input);
                } else {
                    regularGuests.add(input);
                }
            }
        }
    }

    private static void removeArrivedGuestsFromLists(Scanner s, Set<String> vipGuests, Set<String> regularGuests) {
         while (true) {
             String input = s.nextLine();
             if ("END".equals(input)) {
                 break;
             } else {
                 vipGuests.remove(input);
                 regularGuests.remove(input);
             }
         }
    }

    private static void printMissingGuests(Set<String> vipGuests, Set<String> regularGuests) {
        int totalMissingGuests = vipGuests.size() + regularGuests.size();

        System.out.println(totalMissingGuests);

        for (String vipGuest : vipGuests) {
            System.out.println(vipGuest);
        }

        for (String regularGuest : regularGuests) {
            System.out.println(regularGuest);
        }
    }
}
