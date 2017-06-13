package tw.org.model;


import java.util.List;

public interface Cell {
    int getRow();
    int getColumn();


    List<Cell> getNeighbours();
}
