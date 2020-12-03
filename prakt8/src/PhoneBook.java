import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class PhoneBook {
    Map<String, String> phoneBook = new TreeMap<>();
    Scanner scanner = new Scanner(System.in);

    public void cmdListener() {
        boolean go = true;
        while (go) {
            try {
                System.out.println("Введите имя или номер телефона: ");
                String cmd = scanner.nextLine();

                if (cmd.equals("LIST"))
                    phoneBook.forEach((k, v) -> System.out.println(k + ": " + v + "\n"));
                else if (isName(cmd)) {                                 //ввели имя
                    if (phoneBook.containsKey(cmd)) {                     //имя уже есть
                        System.out.println("Телефон: ");
                        System.out.println(phoneBook.get(cmd));
                    } else {                                              //имени нет
                        System.out.println("Введите номер телефона для создания нового контакта.");
                        phoneBook.put(cmd, scanner.nextLine());
                    }
                } else if (isTelNum(cmd))                               //ввели телефон
                    if (phoneBook.containsValue(cmd)) {                    //телефон уже есть
                        System.out.println("Телефон принадлежит: ");
                        phoneBook.forEach((k, v) -> {
                            if (v.equals(cmd)) {
                                System.out.println(k);
                                return;
                            }
                        });
                    } else {                                               //телефона нет
                        System.out.println("Введите имя для создания нового контакта.");
                        phoneBook.put(scanner.nextLine(), cmd);
                    }
                else if (cmd.equals("С") || cmd.equals("C"))               //завершение программы
                    go = false;
                else
                    System.out.println("Команда не распознана!");
            } catch (Exception e) {
                System.out.println("Некорректный ввод!");
            }

        }
    }

    private boolean isName(String name) {
        return name.matches("[А-Я][а-я]+\\s[А-Я][а-я]+");
    }

    private boolean isTelNum(String num) {
        if (num.replaceAll("[()\\-+\\s]", "").length() == 11)
            return true;
        return false;
    }
}
