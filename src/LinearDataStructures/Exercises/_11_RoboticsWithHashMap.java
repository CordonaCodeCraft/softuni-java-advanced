
// TODO: 19.06.2020 г. Judge not ready 60/100, time limit tests do not pass

package LinearDataStructures.Exercises;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class _11_RoboticsWithHashMap {
    public static void main(String[] args) throws IOException {
        BufferedReader s = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder reports = new StringBuilder();
        Map<String, int[]> robots = new LinkedHashMap<>();
        Deque<String> assemblyLine = new ArrayDeque<>();
        String[] robotsInput = s.readLine().split(";");
        int[] clock = generateClock(s.readLine());
        generateRobots(robots, robotsInput);
        feedAssemblyLine(s, assemblyLine);
        int timer = calculateStartTimeInSeconds(clock);

        while (!assemblyLine.isEmpty()) {
            timer++;
            String product = assemblyLine.poll();
            String freeRobot = traverseRobots(robots);
            if (freeRobot.equals("No free robot")) {
                assemblyLine.offer(product);
            } else {
                reports.append(printRobotReport(freeRobot, product, timer)).append(System.lineSeparator());
            }
        }
        System.out.println(reports);
    }

    private static int[] generateClock(String nextLine) {
        return Arrays
                .stream(nextLine.split(":"))
                .mapToInt(Integer::parseInt)
                .toArray();
    }

    private static void generateRobots(Map<String, int[]> robots, String[] robotsInput) {
        for (String robot : robotsInput) {
            String[] robotTokens = robot.split("-");
            String robotName = robotTokens[0];
            int defaultRobotCounter = Integer.parseInt(robotTokens[1]);
            int[] robotCounters = new int[2];
            Arrays.fill(robotCounters, defaultRobotCounter);
            robots.put(robotName, robotCounters);
        }
    }

    private static void feedAssemblyLine(BufferedReader s, Deque<String> assemblyLine) throws IOException {
        while (true) {
            String product = s.readLine();
            if ("End".equals(product)) {
                break;
            } else {
                assemblyLine.offer(product);
            }
        }    }

    private static int calculateStartTimeInSeconds(int[] clock) {
        int hours = clock[0];
        int minutes = clock[1];
        int seconds = clock[2];
        return hours * 3600 + minutes * 60 + seconds;
    }

    private static String traverseRobots(Map<String, int[]> robots) {
        String freeRobot = "x";
        for (String robot : robots.keySet()) {
            int defaultCounter = robots.get(robot)[0];
            int processCounter = robots.get(robot)[1];
            boolean robotIsFree = processCounter == defaultCounter || processCounter == 0;
            if (robotIsFree) {
                boolean robotIsIdle = processCounter == 0;
                boolean productNotAssigned = freeRobot.equals("x");
                if (productNotAssigned) {
                    freeRobot = robot;
                    if (robotIsIdle) {
                        processCounter = defaultCounter;
                        processCounter--;
                        robots.get(robot)[1] = processCounter;
                    } else {
                        processCounter--;
                        robots.get(robot)[1] = processCounter;
                    }
                }
            } else {
                processCounter--;
                robots.get(robot)[1] = processCounter;
            }
        }
        if (freeRobot.equals("x")) {
            return "No free robot";
        } else {
            return freeRobot;
        }
    }

    private static String printRobotReport(String robot, String currentProduct, int startTime) {
        long seconds = startTime % 60;
        long minutes = (startTime / 60) % 60;
        long hours = (startTime / (60 * 60)) % 24;
        return String.format("%s - %s [%02d:%02d:%02d]", robot, currentProduct, hours, minutes, seconds);
    }

}