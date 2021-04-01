
// TODO: 11.07.2020 г. Judge not ready 90/100

package SetsAndMaps.Lab;

import java.util.*;

public class _05_AverageStudentsGrades {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int studentsCount = Integer.parseInt(s.nextLine());

        Map<String, List<Double>> studentsDatabase = generateStudentsDataBase(s, studentsCount);

        printResult(studentsDatabase);


    }

    private static Map<String, List<Double>> generateStudentsDataBase(Scanner s, int studentsCount) {
        Map<String, List<Double>> studentsDatabase = new TreeMap<>();

        for (int i = 0; i < studentsCount; i++) {
            String[] tokens = s.nextLine().split(" ");
            String name = tokens[0];
            double grade = Double.parseDouble(tokens[1]);
            studentsDatabase.putIfAbsent(name, new ArrayList<>());
            studentsDatabase.get(name).add(grade);
        }

        return studentsDatabase;
    }

    private static void printResult(Map<String, List<Double>> studentsDatabase) {

        for (String student : studentsDatabase.keySet()) {
            StringBuilder grades = new StringBuilder();

            for (int i = 0; i < studentsDatabase.get(student).size(); i++) {
                grades.append(String.format("%.2f ",studentsDatabase.get(student).get(i)));
            }

            double averageGrade = studentsDatabase.get(student)
                    .stream()
                    .mapToDouble(Double::doubleValue)
                    .average()
                    .getAsDouble();

            System.out.printf("%s -> %s(avg: %.2f)%n", student, grades.toString(), averageGrade);
        }
    }
}
