package Employees;

public class Operator extends Employee implements EmployeePosition {
    public Operator(String name, String surname, String position, double salary) {
        super(name, surname, position, salary);
    }

    @Override
    public String getJobTitle() {
        return getPosition();
    }

    @Override
    public double calcSalary() {
        return getSalary();
    }
}
