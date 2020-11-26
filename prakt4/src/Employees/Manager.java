package Employees;

public class Manager extends Employee implements EmployeePosition {
    private double companyIncome;
    public Manager(String name, String surname, String position, double salary) {
        super(name, surname, position, salary);
        companyIncome = 115_000 + (Math.random() * 25_000);
    }

    @Override
    public String getJobTitle() {
        return getPosition();
    }

    @Override
    public double calcSalary() {
        return getSalary() + companyIncome * 0.05;
    }
}
