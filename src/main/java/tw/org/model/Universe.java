package tw.org.model;

import tw.org.gameoflife.InputParser;

import java.util.ArrayList;
import java.util.List;

public class Universe {

    private Grid grid;

    public Universe(ArrayList<String> seedPattern) {
        grid = new InputParser().createGrid(seedPattern);
    }

    public State getNextState() {
        List<Cell> nextGeneration = grid.createNextGeneration();

        List<Cell> aliveCells = grid.getExpectedAliveCells();

        aliveCells.addAll(nextGeneration);

        grid = new Grid(aliveCells);

        return new State(grid);
    }
}
