import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CSVLogic {
    public final String CSV_FILE = "./movementList.csv";
    Map<String, Double> companyExpense = new TreeMap<>();

    public List<String[]> readCSV(String separator, String fileName) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            List<String[]> list = new ArrayList<>();
            String line = "";
            while ((line = reader.readLine()) != null) {
                String[] arr = line.split(separator);
                list.add(arr);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public double colSum(List<String[]> data, int row) {
        double sum = 0;
        for (int i = 1; i < data.size(); i++) {
            sum += extractExpense(data.get(i)[row], data.get(i));
        }
        return sum;
    }

    public void expensesByOrganization(List<String[]> data) {
        for (int i = 1; i < data.size() - 1; i++) {
            double elExp = extractExpense(data.get(i)[7], data.get(i));          //затрата текущей компании
            String companyName = extractCompanyName(data.get(i)[5]);             //имя компании
            if (companyExpense.containsKey(companyName)) {                       //компания уже записана
                double t = companyExpense.get(companyName);
                companyExpense.put(companyName, t + elExp);
            } else                                                               //компания встречается впервые
                companyExpense.put(companyName, elExp);
        }
    }

    public double extractExpense(String expense, String[] mas) {
        if (expense.contains("\"") && mas.length == 9) {
            expense = expense + "," + mas[8];
            return (Double.parseDouble(expense.replace('\"', ' ').replace(',', '.')));
        } else
            return Double.parseDouble(expense);
    }

    public String extractCompanyName(String data) {
        Pattern pattern;
        String res = "не нашлось";
        if (data.indexOf('>') > 0) {
            pattern = Pattern.compile("/[^/]+>");

        } else {
            pattern = Pattern.compile("\\\\.+?\\s{2,}");
        }

        Matcher matcher = pattern.matcher(data);
        while (matcher.find()) {
            int start = matcher.start();
            int end = matcher.end();
            res = data.substring(start, end).replaceAll("[\\\\>/]", " ")
                    .replaceAll("\\s{2,}", "");
        }
        return res;
    }
}


