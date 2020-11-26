package Employees;

public class Employee implements EmployeePosition{
    private String name, surname, position;
    private double salary;

    public Employee(String name, String surname, String position, double salary) {
        this.name = name;
        this.surname = surname;
        this.position = position;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String getJobTitle() {
        return null;
    }

    @Override
    public double calcSalary() {
        return 0;
    }
}
