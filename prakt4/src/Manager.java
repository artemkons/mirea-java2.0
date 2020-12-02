public class Manager implements EmployeePosition {
    private final double companyIncome;

    public Manager() {
        companyIncome = 115_000 + (Math.random() * 25_000);
    }

    @Override
    public String getJobTitle() {
        return "Manager";
    }

    @Override
    public double calcSalary(double baseSalary) {
        return companyIncome * 0.05 + baseSalary;
    }
}
