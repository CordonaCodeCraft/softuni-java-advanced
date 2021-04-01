// TODO: 11.07.2020 г. Judge not ready 40/100. Not important. Main logic is perfect, the problem is with the insane requested output    

package SetsAndMaps.Lab;

import java.text.DecimalFormat;
import java.util.*;

public class _08_AcademyGraduation {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int studentsCount = Integer.parseInt(s.nextLine());
        Map<String, double[]> studentsDataBase = populateStudentsDataBase(s, studentsCount);
        printResult(studentsDataBase);

    }

    private static Map<String, double[]> populateStudentsDataBase(Scanner s, int studentsCount) {
        Map<String, double[]> studentsDataBase = new TreeMap<>();

        for (int i = 0; i < studentsCount; i++) {
            String studentName = s.nextLine();

            double[] grades = Arrays
                    .stream(s.nextLine().split(" "))
                    .mapToDouble(Double::parseDouble)
                    .toArray();

            studentsDataBase.putIfAbsent(studentName, grades);
        }

        return studentsDataBase;
    }

    private static void printResult(Map<String,double[]> studentsDataBase) {
        for (String student : studentsDataBase.keySet()) {
            double sum = Arrays.stream(studentsDataBase.get(student)).sum();
            double averageGrade = sum/studentsDataBase.get(student).length;
            System.out.printf("%s is graduated with %s%n", student,new DecimalFormat("##.#######").format(averageGrade));
        }
    }
}

