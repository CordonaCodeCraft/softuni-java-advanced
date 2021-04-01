// Judge ready

package DefiningClasses.Exercises.CompanyRoster;

import java.util.*;

public class Main {

    private static final Map<String, List<Employee>> employeesDatabase = new HashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int employeesCount = Integer.parseInt(scanner.nextLine());

        while (--employeesCount >= 0) {
            feedEmployeesDatabase(scanner);
        }

        employeesDatabase
                .entrySet()
                .stream()
                .sorted((f, s) -> Double.compare(calculateAverageSalary(s), calculateAverageSalary(f)))
                .limit(1)
                .forEach(Main::printDepartment);
    }

    private static void feedEmployeesDatabase(Scanner s) {
        String input = s.nextLine();
        String[] tokens = input.split("\\s+");
        String name = tokens[0];
        double salary = Double.parseDouble(tokens[1]);
        String position = tokens[2];
        String department = tokens[3];
        boolean containsAge = Character.isDigit(tokens[tokens.length - 1].charAt(0));
        boolean containsEmail = input.contains("@");
        List<Employee> departmentStaffList = new ArrayList<>();

        if (containsAge && containsEmail) {
            String email = tokens[4];
            int age = Integer.parseInt(tokens[5]);
            Employee currentEmployee = new Employee(name, salary, position, department, email, age);
            feedDepartment(department, currentEmployee, departmentStaffList);
        } else if (!containsAge && !containsEmail) {
            Employee currentEmployee = new Employee(name, salary, position, department);
            feedDepartment(department, currentEmployee, departmentStaffList);
        } else {
            if (!containsAge) {
                String email = tokens[4];
                Employee currentEmployee = new Employee(name, salary, position, department, email);
                feedDepartment(department, currentEmployee, departmentStaffList);
            }

            if (!containsEmail) {
                int age = Integer.parseInt(tokens[4]);
                Employee currentEmployee = new Employee(name, salary, position, department, age);
                feedDepartment(department, currentEmployee, departmentStaffList);
            }
        }

    }

    private static void feedDepartment(String department, Employee currentEmployee, List<Employee> departmentStaffList) {
        employeesDatabase.putIfAbsent(department, departmentStaffList);
        employeesDatabase.get(department).add(currentEmployee);
    }

    private static Double calculateAverageSalary(Map.Entry<String, List<Employee>> department) {

        return department
                .getValue()
                .stream()
                .mapToDouble(Employee::getSalary)
                .average()
                .getAsDouble();


    }

    private static void printDepartment(Map.Entry<String, List<Employee>> thisDepartment) {
        String department = thisDepartment.getKey();
        System.out.printf("Highest Average Salary: %s%n", department);

        employeesDatabase
                .get(department)
                .sort(Comparator.comparingDouble(Employee::getSalary).reversed());

        employeesDatabase
                .get(department)
                .forEach(Employee::printEmployee);

    }
}
