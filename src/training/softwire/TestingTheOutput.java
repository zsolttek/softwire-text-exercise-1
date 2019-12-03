package training.softwire;

import org.junit.Assert;
import org.junit.Test;

public class TestingTheOutput {

    @Test
    public void headerOutput() {
        // Given
        Table table = new Table();
        String leftHeader = "\uFEFFPublication Date";
        String middleHeader = "Title";
        String rightHeader = "Authors";
        table.addHeader(leftHeader, middleHeader, rightHeader);

        // When
        String header = table.getRows().get(0);

        // Then
        Assert.assertEquals("|\uFEFFPub Date    |                         Title | Authors               |", header);
    }

    @Test
    public void rowOutputIfAnInputIsLong() {
        // Given
        Table table = new Table();
        String leftRow = "29/07/1954";
        String middleRow = "Lord of the Rings";
        String rightRow = "John Ronald Reuel Tolkien";

        table.addRow(leftRow, middleRow, rightRow);

        // When
        String row = table.getRows().get(0);

        // Then
        Assert.assertNotEquals("| 29 Jul 1954 |             Lord of the Rings | John Ronald Reuel Tolkien |", row);
        Assert.assertEquals("| John Ronald Reuel ... |", row.substring(46));
    }

    @Test
    public void rowOutputIfAnInputIsShort() {
        // Given
        Table table = new Table();
        String leftRow = "21/06/2003";
        String middleRow = "Harry Potter and the Order of the Phoenix";
        String rightRow = "Joanne Rowling";

        table.addRow(leftRow, middleRow, rightRow);

        // When
        String row = table.getRows().get(0);

        // Then
        Assert.assertEquals("|        Joanne Rowling |", row.substring(46));
    }
}
