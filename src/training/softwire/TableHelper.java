package training.softwire;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TableHelper {
    private List<String> file;

    public TableHelper(List<String> file) {
        this.file = file;
    }

    public List<String> getHeader() {
        return Arrays.asList(file.get(0).split(","));
    }

    public List<String[]> getRows() {
        List<String[]> rows = new ArrayList<>();

        for(int i = 0; i <= file.size() - 1; i++) {
            if(i > 0) {
                rows.add(file.get(i).split(","));
            }
        }

        return rows;
    }
}
