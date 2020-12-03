import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Email {
    private Set<String> emailTree = new TreeSet<>();

    public void getEmail() {
        boolean go = true;
        Scanner scanner = new Scanner(System.in);
        String cmd;

        while (go) {
            try {
                cmd = scanner.nextLine();
                String[] el = cmd.split(" ");

                if (el[0].equals("LIST"))
                    showEmails();
                else if (el[0].equals("ADD")) {
                    if (isCorrect(el[1]))
                        emailTree.add(el[1]);
                    else
                        System.out.println("Адресс почты некорректен");
                } else if (el[0].equals("C"))
                    go = false;
                else {
                    System.out.println("Неизвестная команда!");
                }
            } catch (Exception e) {
                System.out.println("Некорректный ввод!");
            }


        }
    }

    public void showEmails() {
        Iterator<String> itr = emailTree.iterator();
        while (itr.hasNext()) {
            System.out.println(itr.next());
        }
    }

    public boolean isCorrect(String email) {
        return email.matches("[a-zA-Z0-9]+@[a-z]+\\.[a-z]+");
    }
}
