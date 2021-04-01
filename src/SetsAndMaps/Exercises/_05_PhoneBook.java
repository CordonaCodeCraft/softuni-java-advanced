
// Judge ready

package SetsAndMaps.Exercises;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class _05_PhoneBook {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        Map<String, String> phoneBook = generatePhoneBook(s);

        printSearchResult(s, phoneBook);
    }

    private static Map<String, String> generatePhoneBook(Scanner s) {
        Map<String, String> phoneBook = new HashMap<>();

        while (true) {
            String input = s.nextLine();
            if ("search".equals(input)) {
                break;
            } else {
                String[] tokens = input.split("-");
                String name = tokens[0];
                String phoneNumber = tokens[1];
                phoneBook.put(name, phoneNumber);
            }
        }

        return phoneBook;
    }

    private static void printSearchResult(Scanner s, Map<String, String> phoneBook) {
        
        while (true) {
            String searchQuery = s.nextLine();
            if ("stop".equals(searchQuery)) {
                break;
            } else {
                 if (phoneBook.containsKey(searchQuery)) {
                     String phoneNumber = phoneBook.get(searchQuery);
                     System.out.printf("%s -> %s%n", searchQuery, phoneNumber);
                 }  else {
                     System.out.printf("Contact %s does not exist.%n", searchQuery);
                 }
            }
        }
    }
}
