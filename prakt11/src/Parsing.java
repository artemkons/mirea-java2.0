import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class Parsing {
    private final String MIREA_URL;

    public Parsing(String MIREA_URL) {
        this.MIREA_URL = MIREA_URL;
    }

    public void getImages() {
        File imgFile = new File("./img");
        imgFile.mkdir();

        try {
            Document doc = Jsoup.connect(MIREA_URL).get();
            Elements images = doc.getElementsByTag("img");
            for (Element img : images) {
                String src = img.attr("abs:src");
                if (!src.equals("") && !src.contains("\\")) {
                    byte[] b = Jsoup.connect(src)
                            .ignoreContentType(true).execute().bodyAsBytes();

                    String fileName = src.substring(src.lastIndexOf('/') + 1)
                            .replaceAll("[?]", "");

                    FileOutputStream out = new FileOutputStream(
                            new File("img/" + fileName));
                    out.write(b);
                    out.close();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
