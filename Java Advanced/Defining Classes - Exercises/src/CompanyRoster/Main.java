package CompanyRoster;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        Map<String, Department> departmentMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String[] split = reader.readLine().split("\\s+");
            if (split.length == 5) {
                String department = split[3];
                Employee employee = new Employee(split[0], Double.parseDouble(split[1]), split[2]);
                if (Character.isDigit(split[4].charAt(0))) {
                    employee.setAge(Integer.parseInt(split[4]));
                } else {
                    employee.setEmail(split[4]);
                }
                Department department1 = new Department();
                department1.addEmployee(employee);
                if (!departmentMap.containsKey(department)) {
                    departmentMap.put(department, department1);
                } else {
                    departmentMap.get(department).addEmployee(employee);
                }

            } else if (split.length == 6) {
                String department = split[3];
                Employee employee = new Employee(split[0], Double.parseDouble(split[1]), split[2]);
                employee.setEmail(split[4]);
                employee.setAge(Integer.parseInt(split[5]));
                Department department1 = new Department();
                department1.addEmployee(employee);
                if (!departmentMap.containsKey(department)) {
                    departmentMap.put(department, department1);
                } else {
                    departmentMap.get(department).addEmployee(employee);
                }

            } else if (split.length == 4) {
                Employee employee = new Employee(split[0], Double.parseDouble(split[1]), split[2]);
                String department = split[3];
                Department department1 = new Department();
                department1.addEmployee(employee);
                if (!departmentMap.containsKey(department)) {
                    departmentMap.put(department, department1);
                } else {
                    departmentMap.get(department).addEmployee(employee);
                }
            }


        }
        Map<String, Department> sortedDepartments = new LinkedHashMap<>();
        departmentMap.entrySet().stream().sorted((e1, e2) -> {
            int sorted = Double.compare(e2.getValue().getAverageSalary(), e1.getValue().getAverageSalary());
            return sorted;
        }).forEach(e -> sortedDepartments.put(e.getKey(), e.getValue()));

        sortedDepartments.entrySet().stream().limit(1).forEach(e -> {
            System.out.println(String.format("Highest Average Salary: %s", e.getKey()));
            e.getValue().getEmployees().stream()
                    .sorted((emp1, emp2) -> Double.compare(emp2.getSalary(), emp1.getSalary()))
                    .forEach(x -> System.out.println(String.format("%s %.2f %s %d", x.getName(),
                            x.getSalary(), x.getEmail(), x.getAge())));

        });


    }
}