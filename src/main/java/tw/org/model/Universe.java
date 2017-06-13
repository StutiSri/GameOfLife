package tw.org.model;

import java.util.ArrayList;
import java.util.List;

public class Universe {
    private  List<Cell> aliveCells;
    private  List<Cell> nextGeneration;

    public Universe(ArrayList<Cell> aliveCells) {

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
        List<Cell> possibleNextGeneration = new ArrayList<>();
        nextGeneration = new ArrayList<>();

        for (Cell aliveCell : aliveCells) {
            List<Cell> cellNeighbours = aliveCell.getNeighbours();
            for(Cell neighboringCell : cellNeighbours){
                if(!isAlive(neighboringCell))
                    addDeadCellToPossibleNextGeneration(possibleNextGeneration, neighboringCell);
            }
        }

        for (Cell possibleAliveCell : possibleNextGeneration) {
            System.out.println(possibleAliveCell + " " + possibleAliveCell.getNumberOfAliveNeighbors());
            if (possibleAliveCell.getNumberOfAliveNeighbors() == 3)
                nextGeneration.add(possibleAliveCell);
        }
        return nextGeneration;
    }


    private void addDeadCellToPossibleNextGeneration(List<Cell> possibleNextGeneration,
                                                     Cell deadCell) {
        Cell cell = findCell(possibleNextGeneration, deadCell);
        if(cell == null) {
            cell = deadCell;
            possibleNextGeneration.add(cell);
        }
        cell.incrementNumberOfAliveNeighbors();
    }

    private Cell findCell(List<Cell> possibleNextGeneration, Cell deadCell) {
        for(Cell cell : possibleNextGeneration){
            if(cell.equals(deadCell))
                return cell;
        }
        return null;
    }


    public boolean isAlive(Cell cell) {
        return aliveCells.contains(cell);
    }

    public List<Cell> tick() {
        List<Cell> nextGeneration = createNextGeneration();

        aliveCells = getExpectedAliveCells();

        aliveCells.addAll(nextGeneration);

        return aliveCells;
    }

    public List<Cell> getExpectedAliveCells() {
        calculateNumberOfAliveNeighbors();

        List<Cell> expectedAliveCells = new ArrayList<>();

        for(Cell aliveCell : aliveCells){
            System.out.println(aliveCell + " " + aliveCell.getNumberOfAliveNeighbors());
            if(aliveCell.getNumberOfAliveNeighbors() == 2 || aliveCell
                    .getNumberOfAliveNeighbors() == 3 )
                expectedAliveCells.add(aliveCell);
        }

        return expectedAliveCells;
    }

    private void calculateNumberOfAliveNeighbors() {
        for (Cell aliveCell : aliveCells) {
            List<Cell> cellNeighbours = aliveCell.getNeighbours();
            for(Cell neighboringCell : cellNeighbours){
                if(isAlive(neighboringCell)) {
                    aliveCell.incrementNumberOfAliveNeighbors();
                }
            }
        }
    }
}
