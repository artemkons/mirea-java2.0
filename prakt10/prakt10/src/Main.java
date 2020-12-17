import java.io.File;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        FileLogic file = new FileLogic();

        boolean go = true;
        while (go) {
            String str = scanner.nextLine();
            if (str.equals("C"))
                go = false;
            else
                FileLogic.logging(str);
        }

//        System.out.println("Ввыедите адрес папки: ");
//        String path = scanner.nextLine();
//
//        System.out.println(FileLogic.getFolderSize(path));
//        System.out.println("Откуда?");
//        File from = new File(scanner.nextLine());
//        System.out.println("Куда?");
//        File to = new File(scanner.nextLine());
//
//        file.copyFile(from, to);
    }
}
