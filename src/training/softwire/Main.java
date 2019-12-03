package training.softwire;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        run();
    }

    private static void run() {
        List<String> file = CSV.parse();
        TableHelper tableHelper = new TableHelper(file);
        Table table = new Table();

        List<String> header = tableHelper.getHeader();
        List<String[]> rows = tableHelper.getRows();

        table.addHeader(header.get(0), header.get(1), header.get(2));
        for(String[] row : rows) {
            table.addRow(row[0], row[1], row[2]);
        }

        System.out.println(" ");
        table.display();
    }
}
