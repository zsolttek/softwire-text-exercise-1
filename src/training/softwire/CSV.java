package training.softwire;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class CSV {

    public static List<String> parse() {
        String filename = "books.csv";
        List<String> file = null;

        try {
            file = (Files.readAllLines(Paths.get(filename), Charset.forName("utf-8")));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return file;
    }
}
