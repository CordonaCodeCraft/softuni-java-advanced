// Judge ready

package SetsAndMaps.Exercises;

import java.util.*;

public class _11_LogsAggregator {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int usersCount = Integer.parseInt(s.nextLine());

        Map<String, TreeMap<String, Integer>> userDataBase = generateUserDataBase(s, usersCount);

        printUserDataBaseStatistics(userDataBase);
    }

    private static Map<String, TreeMap<String, Integer>> generateUserDataBase(Scanner s, int usersCount) {

        Map<String, TreeMap<String, Integer>> userDataBase = new TreeMap<>();

        for (int i = 0; i < usersCount; i++) {

            String[] tokens = s.nextLine().split("\\s+");
            String IP = tokens[0];
            String user = tokens[1];
            int thisSessionDuration = Integer.parseInt(tokens[2]);

            userDataBase.putIfAbsent(user, new TreeMap<String, Integer>());

            if (userDataBase.get(user).containsKey(IP)) {
                int totalSessionDuration = userDataBase.get(user).get(IP);
                userDataBase.get(user).put(IP, thisSessionDuration + totalSessionDuration);
            } else {
                userDataBase.get(user).put(IP, thisSessionDuration);
            }
        }

        return userDataBase;
    }

    private static void printUserDataBaseStatistics(Map<String, TreeMap<String, Integer>> userDataBase) {
        userDataBase
                .entrySet()
                .forEach(user -> printUserLogs(user));
    }

    private static void printUserLogs(Map.Entry<String, TreeMap<String, Integer>> user) {

        int totalSessionsDuration = user
                .getValue()
                .values()
                .stream()
                .mapToInt(Integer::intValue)
                .sum();

        List<String> userIPs = new ArrayList<>(user.getValue().keySet());

        System.out.printf("%s: %d %s%n", user.getKey(), totalSessionsDuration, userIPs);

    }
}
