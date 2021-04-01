// TODO: 19.06.2020 г. Judge not ready 80/100

package LinearDataStructures.Exercises;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

public class _11_RoboticsWithArrays {
    public static void main(String[] args) {
        Deque<String> assemblyLine = new ArrayDeque<>();
        Scanner s = new Scanner(System.in);
        String[] input = s.nextLine().split(";");
        String[] robots = new String[input.length];
        int[] defaultCounters = new int[input.length];
        int[] processCounters = new int[input.length];
        int[] clock = generateClock(s.nextLine());
        generateRobotsParameters(input, robots, defaultCounters, processCounters);
        feedProductsLine(s, assemblyLine);
        int startTime = calculateSTartTimeInSeconds(clock);

        while (!assemblyLine.isEmpty()) {
            startTime++;
            String currentProduct = assemblyLine.poll();
            String[] reportTokens = scanThroughRobots(robots, defaultCounters, processCounters);
            boolean foundFreeRobot = reportTokens[1].equals("Found free robot");
            if (foundFreeRobot) {
                String robot = reportTokens[0];
                printRobotReport(robot, currentProduct, startTime);
            } else {
                assemblyLine.offer(currentProduct);
            }
        }
    }

    private static void generateRobotsParameters(String[] input, String[] robots, int[] defaultCounters, int[] processCounters) {
        for (int i = 0; i < input.length; i++) {
            String[] currentTokens = input[i].split("-");
            String robot = currentTokens[0];
            robots[i] = robot;
            int counter = Integer.parseInt(currentTokens[1]);
            defaultCounters[i] = counter;
            processCounters[i] = counter;
        }
    }

    private static int[] generateClock(String nextLine) {
        return Arrays
                .stream(nextLine.split(":"))
                .mapToInt(Integer::parseInt)
                .toArray();
    }

    private static int calculateSTartTimeInSeconds(int[] clock) {
        int hours = clock[0];
        int minutes = clock[1];
        int seconds = clock[2];
        return hours * 3600 + minutes * 60 + seconds;
    }

    private static void feedProductsLine(Scanner s, Deque<String> assemblyLine) {
        while (true) {
            String product = s.nextLine();
            if ("End".equals(product)) {
                break;
            } else {
                assemblyLine.offer(product);
            }
        }
    }

    private static String[] scanThroughRobots(String[] robots, int[] defaultCounters, int[] processCounters) {
        String[] statusTokens = new String[2];
        for (int i = 0; i < processCounters.length; i++) {
            int processCounter = processCounters[i];
            int defaultCounter = defaultCounters[i];
            String robot = robots[i];
            boolean foundFreeRobot = processCounter == defaultCounter && statusTokens[0] == null;
            boolean robotIsProcessing = processCounter != defaultCounter && processCounter > 0;
            boolean robotIsIdle = processCounter == 0;
            if (foundFreeRobot) {
                processCounters[i]--;
                statusTokens[0] = robot;
                statusTokens[1] = "Found free robot";
            } else {
                if (robotIsProcessing) {
                    processCounters[i]--;
                } else if (robotIsIdle) {
                    processCounters[i] = defaultCounters[i];
                    processCounters[i]--;
                    statusTokens[0] = robot;
                    statusTokens[1] = "Found free robot";
                }
            }
        }

        if (statusTokens[0] == null) {
            statusTokens[0] = "x";
        }

        if (statusTokens[1] == null) {
            statusTokens[1] = "x";
        }
        return statusTokens;
    }

    private static void printRobotReport(String robot, String currentProduct, int startTime) {
        long seconds = startTime % 60;
        long minutes = (startTime / 60) % 60;
        long hours = (startTime / (60 * 60)) % 24;
        String clockPrint = String.format("[%02d:%02d:%02d]", hours, minutes, seconds);
        System.out.printf("%s - %s %s%n", robot, currentProduct, clockPrint);
    }
}