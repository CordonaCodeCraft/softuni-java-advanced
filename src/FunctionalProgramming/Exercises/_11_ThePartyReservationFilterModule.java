// Judge ready

package FunctionalProgramming.Exercises;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class _11_ThePartyReservationFilterModule {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        List<String> reservations = new ArrayList<>(Arrays.asList(s.nextLine().split("\\s+")));

        List<String> filterTokens = generateInstructionsList(s);

        reservations
                .stream()
                .filter(guest -> filterGuest(guest, filterTokens))
                .forEach(guest -> System.out.printf("%s ", guest));
        
    }


    private static boolean filterGuest(String guest, List<String> filterTokens) {
        boolean isValidGuest = true;

        for (String filterToken : filterTokens) {
            if (!isValidGuest) {
                break;
            } else {

                String[] tokens = filterToken.split(";");
                String criteria = tokens[0];
                String filter = tokens[1];

                switch (criteria) {
                    case "Starts with": {
                        String substring = guest.substring(0, filter.length());
                        if (substring.equals(filter)) {
                            isValidGuest = false;
                        }
                        break;
                    }
                    case "Ends with": {
                        String substring = guest.substring(guest.length() - filter.length());
                        if (substring.equals(filter)) {
                            isValidGuest = false;
                        }
                        break;
                    }
                    case "Contains":
                        if (guest.contains(filter)) {
                            isValidGuest = false;
                        }
                        break;
                    case "Length":
                        if (guest.length() == Integer.parseInt(filter)) {
                            isValidGuest = false;
                        }
                        break;
                }
            }
        }

        return isValidGuest;
    }

    private static List<String> generateInstructionsList(Scanner s) {

        List<String> filterTokens = new ArrayList<>();

        while (true) {
            String instruction = s.nextLine();
            if ("Print".equals(instruction)) {
                break;
            } else {
                String[] tokens = instruction.split(";", 2);
                String command = tokens[0];
                String filterToken = tokens[1];

                if (command.equals("Add filter")) {
                    filterTokens.add(filterToken);
                } else if (command.equals("Remove filter")) {
                    filterTokens.remove(filterToken);
                }
            }
        }
        return filterTokens;
    }
}
