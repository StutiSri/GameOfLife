package tw.org.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Cell {
    private final int row;
    private final int column;
    private int numberOfAliveNeighbors;

    public Cell(int x, int y) {

        this.row = x;
        this.column = y;
        numberOfAliveNeighbors = 0;
    }

    @Override
    public String toString() {
        return row + ", " + column;
    }

    @Override
    public boolean equals(Object obj) {
        return obj.toString().equals(toString());
    }

    public List<Cell> getNeighbours() {
        List<Cell> neighbours = new ArrayList<>();
        for (int changeInRow = -1; changeInRow <= 1; changeInRow++) {
            for (int changeInColumn = -1; changeInColumn <= 1; changeInColumn++) {
                Cell neighborCell = new Cell(row + changeInRow,
                        column + changeInColumn);
                if (isValidNeighbourCell(neighborCell)) {
                    neighbours.add(neighborCell);
                }
            }
        }
        return neighbours;
    }

    private boolean isValidNeighbourCell(Cell cell) {
        return cell.getRow() >= 0 && cell.getColumn() >= 0
                && !this.equals(cell);
    }


    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    public int getNumberOfAliveNeighbors() {
        return numberOfAliveNeighbors;
    }

    public void incrementNumberOfAliveNeighbors() {
        numberOfAliveNeighbors++;
    }

    @Override
    public int hashCode() {
        return Objects.hash(row, column);
    }
}
