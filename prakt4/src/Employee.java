public class Employee {
    private String name, surname;
    protected EmployeePosition position;

    public Employee(String name, String surname, EmployeePosition position) {
        this.name = name;
        this.surname = surname;
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", position=" + position +
                '}';
    }
}
