package Employees;

public class TopManager extends Employee implements EmployeePosition {
    private Company company;

    public TopManager(String name, String surname, String position, double salary, Company company) {
        super(name, surname, position, salary);
        this.company = company;
    }

    @Override
    public String getJobTitle() {
        return getPosition();
    }

    @Override
    public double calcSalary() {
        if (company.getIncome() > 10_000_000)
            return getSalary() + 1.5 * getSalary();
        else
            return getSalary();
    }
}
