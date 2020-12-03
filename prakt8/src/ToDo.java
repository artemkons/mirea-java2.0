import java.util.ArrayList;
import java.util.Scanner;

public class ToDo {
    private ArrayList<String> todos = new ArrayList<>();

    public void getCommands() {
        Scanner scanner = new Scanner(System.in);
        boolean go = true;
        while (go) {
            String cmd = scanner.nextLine();
            String[] el = cmd.split(" ");

            try {
                switch (el[0]) {
                    case "LIST" -> list();
                    case "ADD" -> {
                        if (isNum(el[1]) && el.length >= 3) { //вставка со сдвигом
                            add(makeTodo(2, el), Integer.parseInt(el[1]));
                        } else //обычная вставка
                            add(makeTodo(1, el));
                    }
                    case "EDIT" -> edit(makeTodo(2, el), Integer.parseInt(el[1]));
                    case "DELETE" -> delete(Integer.parseInt(el[1]));
                    case "C" -> go = false;
                    default -> System.out.println("Команда не распознана!");
                }
            } catch (Exception e) {
                System.out.println("Некорректный ввод!");
            }
        }
    }

    private void list() {
        int count = 1;
        for (String el : todos)
            System.out.println(count++ + "." + el);
    }

    private void add(String todo) {
        todos.add(todo);
    }

    private void add(String todo, int pos) {
        if (pos > todos.size())
            todos.add(todo);
        else
            todos.add(pos - 1, todo);
    }

    private void edit(String todo, int pos) {
        if (pos > todos.size())
            System.out.println("Нет такой задачи!");
        else
            todos.set(pos - 1, todo);
    }

    private void delete(int pos) {
        if (pos > todos.size())
            System.out.println("Нет такой задачи!");
        else
            todos.remove(pos - 1);
    }

    private boolean isNum(String str) {
        try {
            int num = Integer.parseInt(str);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    private String makeTodo(int from, String[] el) {
        StringBuilder todo = new StringBuilder();

        for (int i = from; i < el.length; i++) { //собираем тудушку из нескольких слов
            todo.append(el[i]);
            todo.append(' ');
        }

        return todo.toString();
    }
}
