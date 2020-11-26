import Employees.*;

public class Main {
    public static void main(String[] args) {
        Company microsoft = new Company("microsoft", 150_000_000);

        for (int i = 0; i < 180; i++) {
            microsoft.hire(new Operator("Test","Testovich","Operator",10_000));
            if(i < 80)
                microsoft.hire(new Manager("Tost", "Tostovich","Manger", 12000));
            if(i < 10)
                microsoft.hire(new TopManager("Kek", "Kekovich","Top manager", 12000, microsoft));
        }
        microsoft.showEmployees();
        microsoft.getTopSalaryStaff(15);
        microsoft.getLowestSalaryStaff(30);

        System.out.println("Уволены");
        microsoft.fire(135);
        microsoft.showEmployees();
        microsoft.getTopSalaryStaff(15);
        microsoft.getLowestSalaryStaff(30);
    }


}
