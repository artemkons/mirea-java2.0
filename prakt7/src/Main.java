import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //Задание 1
        String text = "Вася заработал 5000 рублей, Петя - 7563 рубля, а Маша - 30000 рублей";
        StringBuilder vas = new StringBuilder();
        StringBuilder mash = new StringBuilder();

        boolean shouldWrite = true;
        for (int i = 0; i < text.length(); i++) {
            if (Character.isDigit(text.charAt(i)) && shouldWrite && i < text.indexOf("Маша"))
                vas.append(text.charAt(i));
            else if (Character.isDigit(text.charAt(i)) && shouldWrite && i > text.indexOf("Маша"))
                mash.append(text.charAt(i));
            if (text.charAt(i) == ',')
                shouldWrite = !shouldWrite;
        }

        int sum = Integer.parseInt(vas.toString()) + Integer.parseInt(mash.toString());
        System.out.println(sum);

        //Задание 2

        System.out.println("Введите ФИО: ");
        Scanner scanner = new Scanner(System.in);
        String fio = scanner.nextLine();
        ArrayList<String> name = new ArrayList<>();
        StringBuilder el = new StringBuilder();

        boolean isInvalid = false;
        for (int i = 0; i < fio.length(); i++) {
            if ((fio.charAt(i) >= 'a' && fio.charAt(i) <= 'я')
                    || (fio.charAt(i) >= 'А' && fio.charAt(i) <= 'Я')
                    || fio.charAt(i) == '-')

                el.append(fio.charAt(i));
            else if (fio.charAt(i) == ' ') {
                name.add(el.toString());
                el.setLength(0);
            } else
                isInvalid = true;
        }

        if (el.length() != 0)
            name.add(el.toString());

        if (isInvalid || name.size() < 2)
            System.out.println("Введенная строка не является ФИО");
        else if (name.size() == 3) {
            System.out.println("Фамилия: " + name.get(0) + "\n"
                    + "Имя: " + name.get(1) + "\n"
                    + "Очество: " + name.get(2));
        } else
            System.out.println("Фамилия: " + name.get(0) + "\n"
                    + "Имя: " + name.get(1));


        //Задание 3
        String telNum = scanner.nextLine();
        StringBuilder nums = new StringBuilder();

        for (int i = 0; i < telNum.length(); i++) {
            if (Character.isDigit(telNum.charAt(i)))
                nums.append(telNum.charAt(i));
        }

        boolean correct = true;
        if (nums.charAt(0) == '8')
            nums.setCharAt(0, '7');
        if (nums.length() == 10)
            nums.insert(0, '7');

        if (nums.charAt(0) != '7' || nums.length() != 11)
            correct = false;

        if (correct) {
            nums.insert(0, '+');
            nums.insert(2, ' ');
            nums.insert(3, '(');
            nums.insert(7, ')');
            nums.insert(8, ' ');
            nums.insert(12, '-');
            nums.insert(15, '-');
            System.out.println(nums.toString());
        } else
            System.out.println("Неверный формат номера");
    }

}
