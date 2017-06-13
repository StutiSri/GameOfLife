package tw.org.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Grid {
    private  List<Cell> aliveCells;
    private  List<Cell> nextGeneration;

    public Grid(ArrayList<Cell> aliveCells) {

        this.aliveCells = aliveCells;
    }

    @Override
    public String toString() {
        String gridOutput = "";
        for (Cell cell : aliveCells)
            gridOutput += cell.toString() + "\n";
        return gridOutput;
    }


    public List<Cell> getAliveCells() {
        return aliveCells;
    }

    public List<Cell> createNextGeneration() {
        Map<Cell, Integer> deadCellMap = new HashMap<>();
        nextGeneration = new ArrayList<>();

        for (Cell aliveCell : aliveCells) {
            identifyDeadNeighbours(deadCellMap, aliveCell);

        }

        for (Map.Entry<Cell, Integer> entry : deadCellMap.entrySet()) {
            if (entry.getValue() == 3)
                nextGeneration.add(entry.getKey());
        }
        return nextGeneration;
    }

    private void identifyDeadNeighbours(Map<Cell, Integer> deadCellMap, Cell aliveCell) {
        List<Cell> cellNeighbours = aliveCell.getNeighbours();
        for(Cell neighboringCell : cellNeighbours){
            if(isValidDeadCell(neighboringCell))
                addDeadCellToMap(deadCellMap, neighboringCell);
        }
    }

    private void addDeadCellToMap(Map<Cell, Integer> deadCellMap, Cell
            deadCell) {
        Integer numberOfNeighbours;
        numberOfNeighbours = deadCellMap.get(deadCell);
        System.out.println(deadCell + " " + numberOfNeighbours);
        if (numberOfNeighbours == null)
            numberOfNeighbours = 0;
        numberOfNeighbours++;
        deadCellMap.put(deadCell,
                numberOfNeighbours);
    }


    public boolean isValidDeadCell(Cell cell) {
        if (cell.getRow() < 0 || cell.getColumn() < 0)
            return false;
        return !(aliveCells.contains(cell));
    }

    public List<Cell> tick() {
        return null;
    }
}
