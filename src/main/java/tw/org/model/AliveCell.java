package tw.org.model;

import java.util.ArrayList;
import java.util.List;

public class AliveCell implements Cell {
    private final int row;
    private final int column;
    Cell nextState;

    public AliveCell(int x, int y) {

        this.row = x;
        this.column = y;
    }

    @Override
    public String toString() {
        return row + ", " + column;
    }

    @Override
    public boolean equals(Object obj) {
        return obj.toString().equals(toString());
    }

    @Override
    public int getRow() {
        return row;
    }

    @Override
    public int getColumn() {
        return column;
    }

    public List<Cell> getNeighbours() {
        List<Cell> neighbours = new ArrayList<>();
        for (int changeInRow = -1; changeInRow <= 1; changeInRow++) {
            for (int changeInColumn = -1; changeInColumn <= 1; changeInColumn++) {
                Cell deadCell = new DeadCell(row + changeInRow,
                        column + changeInColumn);
                if (isValidNeighbourCell(deadCell)) {
                    neighbours.add(deadCell);
                }
            }
        }
        return neighbours;
    }

    private boolean isValidNeighbourCell(Cell deadCell) {
        return deadCell.getRow() >= 0 && deadCell.getColumn() >= 0;
    }


}
