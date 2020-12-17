import java.io.File;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        FileLogic file = new FileLogic();

        FileLogic.logging("Введите адрес папки: ");
        String path = FileLogic.logging();

        FileLogic.logging(FileLogic.getFolderSize(path));
        FileLogic.logging("Откуда? ");
        File from = new File(FileLogic.logging());
        FileLogic.logging("Куда? ");
        File to = new File(FileLogic.logging());

        file.copyFile(from, to);
    }
}
