import java.util.ArrayList;

public class Company {
    private ArrayList<Employee> employees = new ArrayList<>();
    private double income;

    public Company(double income) {
        this.income = income;
    }

    public double getIncome() {
        return income;
    }

    public void hire(Employee employee) {
        employees.add(employee);
    }

    public void hireAll(ArrayList<Employee> employees) {
        this.employees.addAll(employees);
    }

    public void fire(int quantity) {
        int size = employees.size();
        for (int i = size - 1; i >= size - quantity; i--)
            employees.remove(i);
    }

    public void getLowestSalaryStaff(int count) {
        if (count < 0) {
            System.err.println("Некорректный ввод!");
            return;
        }

        employees.sort((Employee e1, Employee e2) -> {
            if (e1.position.calcSalary(100_000) - e2.position.calcSalary(100_000) > 0)
                return 1;
            else if (e1.position.calcSalary(100_000) - e2.position.calcSalary(100_000) < 0)
                return -1;
            else
                return 0;
        });


        int max = Math.min(count, employees.size() - 1);

        System.out.println("Наименьшие з/п" + "\n");
        for (int i = 0; i < max; i++) {
            System.out.println("№ " + (i + 1) + "\n" +
                    "Имя: " + employees.get(i).getName() + "\n" +
                    "Должность: " + employees.get(i).position.getJobTitle() + "\n" +
                    "з/п: " + employees.get(i).position.calcSalary(100_000) + "\n");
        }

    }

    public void getTopSalaryStaff(int count) {
        if (count < 0) {
            System.err.println("Некорректный ввод!");
            return;
        }

        employees.sort((Employee e1, Employee e2) -> {
            if (e2.position.calcSalary(100_000) - e1.position.calcSalary(100_000) > 0)
                return 1;
            else if (e2.position.calcSalary(100_000) - e1.position.calcSalary(100_000) < 0)
                return -1;
            else
                return 0;
        });

        int max = Math.min(count, employees.size() - 1);

        System.out.println("Наибольшие з/п" + "\n");
        for (int i = 0; i < max; i++) {
            System.out.println("№ " + (i + 1) + "\n" +
                    "Имя: " + employees.get(i).getName() + "\n" +
                    "Должность: " + employees.get(i).position.getJobTitle() + "\n" +
                    "з/п: " + employees.get(i).position.calcSalary(100_000) + "\n");
        }

    }

    public void showEmployees() {
        int index = 1;
        for (Employee employee : employees) {
            System.out.println(
                    "№ " + index++ + "\n" +
                            "Имя: " + employee.getName() + "\n"
                            + "Фамилия: " + employee.getSurname() + "\n"
                            + "Должность: " + employee.position.getJobTitle() + "\n"
                            + "З/П: " + employee.position.calcSalary(100_000));
        }
    }
}
