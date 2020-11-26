package Employees;

import Employees.Employee;

import java.util.ArrayList;
import java.util.List;

public class Company {
    private String name;
    private final double income;
    private final ArrayList<Employee> employees = new ArrayList<>();

    public Company(String name, double income) {
        this.name = name;
        this.income = income;
    }

    public void hire(Employee employee) {
        employees.add(employee);
    }

    public void hireAll(ArrayList<Employee> employees) {
        this.employees.addAll(employees);
    }

    public void fire(int quantity) {
        int size = employees.size();
        for (int i = size - 1; i >= size - quantity; i--) {
            employees.remove(i);
        }
    }

    public double getIncome() {
        return income;
    }

    public void showEmployees() {
        int index = 1;
        for (Employee employee : employees) {
            System.out.println(
                    "№ " + index++ + "\n" +
                            "Имя: " + employee.getName() + "\n"
                            + "Фамилия: " + employee.getSurname() + "\n"
                            + "Должность: " + employee.getPosition() + "\n"
                            + "Зарплата: " + employee.calcSalary() + "\n");
        }
    }

    public void getLowestSalaryStaff(int count) {
        sort(employees, 0, employees.size() - 1);
        int max = Math.min(count, employees.size());

        System.out.println("Наименьшие з/п" + "\n");
        for (int i = 0; i < max; i++) {
            System.out.println("№ " + (i + 1) + "\n" +
                    "Имя: " + employees.get(i).getName() + "\n" +
                    "Должность: " + employees.get(i).getPosition() + "\n" +
                    "з/п: " + employees.get(i).calcSalary() + "\n");
        }
    }

    public void getTopSalaryStaff(int count) {
        sort(employees, 0, employees.size() - 1);
        int min = Math.max((employees.size() - count), 0);

        System.out.println("Наибольшие з/п" + "\n");
        for (int i = employees.size() - 1; i >= employees.size() - count; i--) {
            System.out.println("№ " + (employees.size() - i) + "\n" +
                    "Имя: " + employees.get(i).getName() + "\n" +
                    "Должность: " + employees.get(i).getPosition() + "\n" +
                    "з/п: " + employees.get(i).calcSalary() + "\n");
        }
    }

    private static void sort(List<Employee> employee, int low, int high) {
        if (employee.size() == 0)
            return;

        if (low >= high)
            return;

        int middle = low + (high - low) / 2;
        Employee opora = employee.get(middle);

        int i = low, j = high;
        while (i <= j) {
            while (employee.get(i).calcSalary() < opora.calcSalary()) {
                i++;
            }

            while (employee.get(j).calcSalary() > opora.calcSalary()) {
                j--;
            }

            if (i <= j) {
                Employee temp = employee.get(i);
                employee.set(i, employee.get(j));
                employee.set(j, temp);
                i++;
                j--;
            }
        }

        if (low < j)
            sort(employee, low, j);

        if (high > i)
            sort(employee, i, high);
    }
}

