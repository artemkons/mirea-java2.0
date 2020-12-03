import java.io.*;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

public class FileLogic {
    private static String[] bytesPrefix = {" Bytes", " KBytes", " MBytes", " GBytes", " TBytes"};

    public static void logging(String str) {
        try {
            FileOutputStream os = new FileOutputStream("log/log.txt", true);
            byte[] buffer = str.getBytes();
            os.write(buffer, 0, buffer.length);
            os.write('\n');
        } catch (IOException e) {
            System.out.println("Ошибка");
        }
    }

    public static void createFolder() {
        File dir = new File("log");
        dir.mkdir();

        try {
            File logFile = new File(dir, "log.txt");
            logFile.createNewFile();
        } catch (Exception e) {
            System.out.println("Не удалось создать файл.");
        }
    }

    public static String getFolderSize(String path) {
        File file = new File(path);
        long size;

        if (file.exists()) {
            size = folderSize(file);
            int i = 0;
            while (size > 1024) {
                size /= 1024;
                i++;
            }
            return size + bytesPrefix[i];
        } else {
            System.out.println("Такой папки не существует");
            return null;
        }
    }

    private static long folderSize(File file) {
        long size = 0;
        try {
            for (File el : file.listFiles()) {
                if (el.isFile())
                    size += el.length();
                else if (el.isDirectory())
                    size += folderSize(el);
            }
        } catch (Exception e) {
        }
        return size;
    }

    public void copyFile(File from, File to) {
        if (from.isDirectory()) {
            if (!to.exists())
                to.mkdir();

            String[] files = from.list();
            if (files == null)
                return;
            for (String file : files) {
                File fromFile = new File(from, file);
                File toFile = new File(to, file);
                copyFile(fromFile, toFile);
            }
        } else {
            try {
                FileInputStream is = new FileInputStream(from);
                FileOutputStream os = new FileOutputStream(to);
                ArrayList<Byte> data = new ArrayList<>();

                int i;
                while ((i = is.read()) > -1) {
                    data.add((byte) i);
                }

                if (data.size() > 0) {
                    byte[] byteData = new byte[data.size()];
                    int j = 0;
                    for (Byte el : data) {
                        byteData[j++] = el;
                    }

                    os.write(byteData, 0, byteData.length);
                }

            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }
}
