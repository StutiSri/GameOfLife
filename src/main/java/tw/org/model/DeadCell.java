package tw.org.model;

import java.util.List;
import java.util.Objects;

public class DeadCell implements Cell {
    private final int row;
    private final int column;

    public DeadCell(int x, int y){
        this.row = x;
        this.column = y;
    }

    @Override
    public int getRow() {
        return row;
    }

    @Override
    public int getColumn() {
        return column;
    }

    @Override
    public List<Cell> getNeighbours() {
        return null;
    }

    @Override
    public String toString() {
        return row + ", " + column;
    }

    @Override
    public boolean equals(Object o) {
        return o instanceof Cell && o.toString().equals(toString());
    }

    @Override
    public int hashCode() {
        return Objects.hash(row, column);
    }
}
