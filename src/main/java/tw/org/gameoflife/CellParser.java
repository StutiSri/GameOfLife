package tw.org.gameoflife;

import tw.org.model.Cell;

public class CellParser {
    public Cell createCell(String inputItem) {
        String[] coordinates = inputItem.split(", ");
        return new Cell(Integer.parseInt(coordinates[0]),
                Integer.parseInt(coordinates[1]));
    }
}
