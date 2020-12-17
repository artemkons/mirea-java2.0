public class Main {
    public static void main(String[] args) {
        Company microsoft = new Company();

        for (int i = 0; i < 180; i++) {
            microsoft.hire(new Employee("Raz", "Dvazovich", new Operator()));
            if (i < 80)
                microsoft.hire(new Employee("Kek", "Kekovich", new Manager()));
            if (i < 10)
                microsoft.hire(new Employee("Lol", "Gr", new TopManager(microsoft)));
        }
        System.out.println(microsoft.countIncome());

        microsoft.getLowestSalaryStaff(15);
        microsoft.getTopSalaryStaff(30);

        System.out.println("Уволены");
        microsoft.fire(135);
        microsoft.showEmployees();
        microsoft.getTopSalaryStaff(15);
        microsoft.getLowestSalaryStaff(30);
    }

}
