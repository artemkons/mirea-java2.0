public class TopManager implements EmployeePosition {
    private Company company;

    public TopManager(Company company) {
        this.company = company;
    }

    @Override
    public String getJobTitle() {
        return "Top Manager";
    }

    @Override
    public double calcSalary(double baseSalary) {
        if (company.countIncome() > 10_000_000)
            return baseSalary * 2.5;
        else
            return baseSalary;
    }

    @Override
    public double getCompanyIncome() {
        return 0;
    }
}
