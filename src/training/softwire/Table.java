package training.softwire;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Table {

    private int LEFT_COLUMN_SIZE = 13;
    private int MIDDLE_COLUMN_SIZE = 31;
    private int RIGHT_COLUMN_SIZE = 23;
    private String VERTICAL = "|";
    private String HORIZONTAL = "|=====================================================================|";
    private String SPACE = " ";

    private List<String> rows = new ArrayList<>();

    public List<String> getRows() {
        return rows;
    }

    public void addHeader(String left, String middle, String right) {
        if(rows.isEmpty()) {
            StringBuilder sb = new StringBuilder();
            sb.append(VERTICAL);
            sb.append(correctLeftForHeader(left));
            sb.append(VERTICAL);
            sb.append(correctMiddleForHeader(middle));
            sb.append(VERTICAL);
            sb.append(correctRightForHeader(right));
            sb.append(VERTICAL);

            rows.add(sb.toString());
            rows.add(HORIZONTAL);
        }
    }

    public void addRow(String left, String middle, String right) {
        StringBuilder sb = new StringBuilder();
        String newLeft = correctLeftColumn(left);
        String newMiddle = correctMiddleColumn(middle);
        String newRight = correctRightColumn(right);

        sb.append(VERTICAL);
        sb.append(newLeft);
        sb.append(VERTICAL);
        sb.append(newMiddle);
        sb.append(VERTICAL);
        sb.append(newRight);
        sb.append(VERTICAL);
        
        rows.add(sb.toString());
    }

    private String correctRightColumn(String text) {
        String trimmedText = text.trim();
        StringBuilder sb = new StringBuilder();
        sb.append(SPACE);

        if(trimmedText.length() == RIGHT_COLUMN_SIZE - 2) {
            sb.append(trimmedText);
        } else if(trimmedText.length() < (RIGHT_COLUMN_SIZE - 2)) {
            int difference = RIGHT_COLUMN_SIZE - trimmedText.length() - 2;
            sb.append(SPACE.repeat(difference));
            sb.append(trimmedText);
        } else {
            String longTitle = trimmedText.substring(0, RIGHT_COLUMN_SIZE - 5);
            sb.append(longTitle);
            sb.append("...");
        }

        sb.append(SPACE);
        return sb.toString();
    }

    private String correctMiddleColumn(String text) {
        String trimmedText = text.trim();
        StringBuilder sb = new StringBuilder();

        sb.append(SPACE);

        if(trimmedText.length() <= MIDDLE_COLUMN_SIZE) {
            int difference = MIDDLE_COLUMN_SIZE - trimmedText.length() - 2;
            sb.append(SPACE.repeat(difference));
            sb.append(trimmedText);
        } else {
            String longTitle = trimmedText.substring(0, MIDDLE_COLUMN_SIZE - 5);
            sb.append(longTitle);
            sb.append("...");
        }

        sb.append(SPACE);
        return sb.toString();
    }

    // 29/07/1954 ==> 29 Jul 1954
    private String correctLeftColumn(String text) {
        HashMap<String, String> months = buildMonthHashMap();
        StringBuilder sb = new StringBuilder();
        String trimmedText = text.trim();

        sb.append(SPACE);
        sb.append(trimmedText, 0, 2);
        sb.append(SPACE);
        sb.append(months.get(trimmedText.substring(3,5)), 0, 3);
        sb.append(SPACE);
        sb.append(trimmedText.substring(6));
        sb.append(SPACE);

        return sb.toString();
    }

    private HashMap<String, String> buildMonthHashMap() {
        HashMap<String, String> months = new HashMap<>();
        months.put("01", "January");
        months.put("02", "February");
        months.put("03", "March");
        months.put("04", "April");
        months.put("05", "May");
        months.put("06", "June");
        months.put("07", "July");
        months.put("08", "August");
        months.put("09", "September");
        months.put("10", "October");
        months.put("11", "November");
        months.put("12", "December");

        return months;
    }

    private String correctRightForHeader(String text) {
        StringBuilder sb = new StringBuilder();
        String trimmedText = text.trim();
        int difference = RIGHT_COLUMN_SIZE - trimmedText.length() - 1;

        sb.append(SPACE);
        sb.append(trimmedText);
        sb.append(SPACE.repeat(difference));
        return sb.toString();
    }

    private String correctMiddleForHeader(String text) {
        StringBuilder sb = new StringBuilder();
        String trimmedText = text.trim();
        int difference = MIDDLE_COLUMN_SIZE - trimmedText.length();
        
        sb.append(SPACE.repeat(difference - 1));
        sb.append(trimmedText);
        sb.append(SPACE);
        return sb.toString();
    }

    private String correctLeftForHeader(String text) {
        StringBuilder sb = new StringBuilder();
        String trimmedText = text.trim();

        if(text.length() - 2 <= LEFT_COLUMN_SIZE) {
            sb.append(trimmedText);
        } else {
            List<String> words = Arrays.asList(trimmedText.split(SPACE));
            for(int i = 0; i <= words.size() - 1; i++) {
                if(i == 0) {
                    sb.append(words.get(i), 0, 4);
                    sb.append(SPACE);
                } else {
                    sb.append(words.get(i));
                }
            }
        }
        int difference = 0;
        if(LEFT_COLUMN_SIZE > sb.length()) {
            difference = LEFT_COLUMN_SIZE - sb.length();
        }

        sb.append(SPACE.repeat(difference));
        return sb.toString();
    }

    public void display() {
        rows.forEach(row -> System.out.println(row));
    }
}
