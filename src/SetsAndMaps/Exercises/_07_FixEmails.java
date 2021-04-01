
// Judge ready

package SetsAndMaps.Exercises;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class _07_FixEmails {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        Map<String, String> eMails = generateEMailsDataBase(s);

        printEMails(eMails);


    }

    private static Map<String, String> generateEMailsDataBase(Scanner s) {
        Map<String, String> eMails = new LinkedHashMap<>();

        String name = "";

        while (true) {
            String input = s.nextLine();
            if ("stop".equals(input)) {
                break;
            } else {
                boolean isName = !input.contains("@");
                if (isName) {
                    name = input;
                    eMails.putIfAbsent(name, "");
                } else {
                    boolean isValidEmail = validateEmail(input);
                    if (isValidEmail) {
                        eMails.put(name,input);
                    } else {
                        eMails.remove(name);
                    }
                }
            }
        }

        return eMails;
    }

    private static boolean validateEmail(String input) {
        String[] tokens = input.split("@");
        return !tokens[1].contains("us") && !tokens[1].contains("uk") && !tokens[1].contains("com");
    }

    private static void printEMails(Map<String, String> eMails) {

        for (String contact : eMails.keySet()) {
            String eMail = eMails.get(contact);
            System.out.printf("%s -> %s%n",contact,eMail);
        }

    }
}
