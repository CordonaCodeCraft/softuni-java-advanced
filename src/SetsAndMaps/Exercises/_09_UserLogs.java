
// Judge ready

package SetsAndMaps.Exercises;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class _09_UserLogs {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        Map<String, LinkedHashMap<String, Integer>> userLogs = generateUserLogs(s);

        printUserLogs(userLogs);

    }

    private static Map<String, LinkedHashMap<String, Integer>> generateUserLogs(Scanner s) {

        Map<String, LinkedHashMap<String, Integer>> userLogs = new TreeMap<>();

        while (true) {
            String input = s.nextLine();
            if ("end".equals(input)) {
                break;
            } else {
                String user = extractUser(input);
                userLogs.putIfAbsent(user, new LinkedHashMap<String, Integer>());
                String IP = extractIP(input);
                userLogs.get(user).putIfAbsent(IP, 0);
                int counter = userLogs.get(user).get(IP) + 1;
                userLogs.get(user).put(IP, counter);
            }
        }
        return userLogs;

    }

    private static String extractUser(String input) {

        return input.substring(input.lastIndexOf("=") + 1);

    }

    private static String extractIP(String input) {

        Pattern IPv4Pattern = Pattern.compile("\\b(?:\\d{1,3}\\.){3}\\d{1,3}\\b");
        Pattern IPv6Pattern = Pattern.compile("(?:[0-9a-fA-F]{1,4}:){7}[0-9a-fA-F]{1,4}");
        Matcher IPv4Matcher = IPv4Pattern.matcher(input);
        Matcher IPv6Matcher = IPv6Pattern.matcher(input);

        if (IPv4Matcher.find()) {
            return IPv4Matcher.group();
        } else if (IPv6Matcher.find()) {
            return IPv6Matcher.group();
        } else {
            return "";
        }

    }

    private static void printUserLogs(Map<String, LinkedHashMap<String, Integer>> userLogs) {

        for (String user : userLogs.keySet()) {
            System.out.printf("%s: %n", user);
            LinkedHashMap<String, Integer> userIPs = userLogs.get(user);

            int length = userIPs.size();

            for (String IP : userIPs.keySet()) {
                int counter = userIPs.get(IP);
                if (length == 1) {
                    System.out.printf("%s => %d.%n", IP, counter);
                } else {
                    length--;
                    if (length > 0) {
                        System.out.printf("%s => %d, ", IP, counter);
                    } else {
                        System.out.printf("%s => %d.", IP, counter);
                    }
                }
            }
        }
    }
}
