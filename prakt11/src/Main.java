import java.util.List;

public class Main {
    public static void main(String[] args) {
        CSVLogic l = new CSVLogic();
        List<String[]> rows = l.readCSV(",", l.CSV_FILE);
        System.out.println("Сумма расходов: " + l.colSum(rows, 7));
        System.out.println("Сумма доходов: " + l.colSum(rows, 6));

        l.expensesByOrganization(rows);
        System.out.println("Суммы расходов по организациям");
        l.companyExpense.forEach((k, v) -> System.out.println(k + ": " + v));

        Parsing p = new Parsing("https://www.mirea.ru/");
        p.getImages();
    }
}
