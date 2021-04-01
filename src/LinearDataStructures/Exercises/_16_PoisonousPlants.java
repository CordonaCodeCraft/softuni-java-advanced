// TODO: 21.06.2020 г. Judge not ready 77/100 Time limits do not pass

package LinearDataStructures.Exercises;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

public class _16_PoisonousPlants {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int plantsCount = Integer.parseInt(s.nextLine());
        Deque<Integer> plantsQueue = generatePlants(s.nextLine());
        int previousPlant = Integer.MAX_VALUE;
        int dayCount = 0;                        
        int survivedPlantsCount = 0;
        int deadPlantsCount = 0;
        boolean cropIsNotStable = true;

        while (cropIsNotStable) {
            int currentPlant = plantsQueue.remove();
            boolean plantWillSurvive = currentPlant <= previousPlant;
            if (plantWillSurvive) {
                previousPlant = currentPlant;
                plantsQueue.offer(currentPlant);
                survivedPlantsCount++;
            } else {
                previousPlant = currentPlant;
                deadPlantsCount++;
            }

            boolean dayIsOver = survivedPlantsCount + deadPlantsCount == plantsCount;

            if (dayIsOver) {
                boolean startNewDay = deadPlantsCount > 0;
                if (startNewDay) {
                    plantsCount = survivedPlantsCount;
                    dayCount++;
                    survivedPlantsCount = 0;
                    deadPlantsCount = 0;
                    previousPlant = Integer.MAX_VALUE;
                } else {
                    cropIsNotStable = false;
                }
            }
        }
        System.out.println(dayCount);
    }

    private static Deque<Integer> generatePlants(String nextLine) {
        Deque<Integer> plantsQueue = new ArrayDeque<>();
        Arrays
                .stream(nextLine.split(" "))
                .map(Integer::parseInt)
                .forEach(plantsQueue::offer);

        return plantsQueue;
    }
}
