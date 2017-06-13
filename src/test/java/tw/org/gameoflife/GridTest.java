package tw.org.gameoflife;

import org.junit.Test;
import tw.org.model.Cell;
import tw.org.model.TestGrid;
import tw.org.model.Grid;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class GridTest {

    @Test
    public void shouldCreateGridForInput(){
        ArrayList<String> seedPattern = new ArrayList<>();
        seedPattern.add("1, 1");
        seedPattern.add("1, 2");
        seedPattern.add("2, 1");
        seedPattern.add("2, 2");
        Grid expectedGrid = new TestGrid(seedPattern);

        Grid grid = new InputParser().createGrid(seedPattern);

        assertEquals(expectedGrid, grid);
    }

    @Test
    public void shouldCreateNextGeneration(){
        ArrayList<String> seedPattern = new ArrayList<>();
        seedPattern.add("0, 1");
        seedPattern.add("1, 1");
        seedPattern.add("1, 0");
        List<Cell> expectedNextGeneration = new ArrayList<>();
        expectedNextGeneration.add(new Cell(0,0));

        Grid grid = new InputParser().createGrid(seedPattern);
        List<Cell> nextGeneration = grid.createNextGeneration();

        assertEquals(expectedNextGeneration, nextGeneration);
    }

    @Test
    public void gridWithOnlyOneCellShouldDie(){
        ArrayList<String> seedPattern = new ArrayList<>();
        seedPattern.add("0, 1");

        Grid grid = new InputParser().createGrid(seedPattern);
        List<Cell> aliveCells = grid.tick();

        assertEquals(new ArrayList<>(),aliveCells);
    }

    @Test
    public void cellWithOnlyOneNeighbourShouldDie(){
        ArrayList<String> seedPattern = new ArrayList<>();
        seedPattern.add("0, 0");
        seedPattern.add("1, 1");
        seedPattern.add("1, 2");
        seedPattern.add("2, 2");

        List<Cell> expectedAliveCells = new ArrayList<>();
        expectedAliveCells.add(new Cell(1,1));
        expectedAliveCells.add(new Cell(1,2));
        expectedAliveCells.add(new Cell(2,2));

        Grid grid = new InputParser().createGrid(seedPattern);
        List<Cell> aliveCells = grid.getExpectedAliveCells();

        assertEquals(expectedAliveCells,aliveCells);
    }
    @Test
    public void cellWithFourNeighboursShouldDie(){
        ArrayList<String> seedPattern = new ArrayList<>();
        seedPattern.add("0, 2");
        seedPattern.add("1, 1");
        seedPattern.add("2, 1");
        seedPattern.add("1, 2");
        seedPattern.add("2, 2");

        List<Cell> expectedAliveCells = new ArrayList<>();
        expectedAliveCells.add(new Cell(0, 2));
        expectedAliveCells.add(new Cell(2, 1));
        expectedAliveCells.add(new Cell(2, 2));

        Grid grid = new InputParser().createGrid(seedPattern);
        List<Cell> aliveCells = grid.getExpectedAliveCells();

        assertEquals(expectedAliveCells,aliveCells);
    }

    @Test
    public void shouldReturnTheStateOfTheSystemAfterOneTick() {
        ArrayList<String> seedPattern = new ArrayList<>();
        seedPattern.add("1, 1");
        seedPattern.add("1, 2");
        seedPattern.add("1, 3");
        seedPattern.add("2, 2");
        seedPattern.add("2, 3");
        seedPattern.add("2, 4");
        List<Cell> expectedAliveCells = new ArrayList<>();
        expectedAliveCells.add(new Cell(1, 1));
        expectedAliveCells.add(new Cell(2, 4));
        expectedAliveCells.add(new Cell(0, 2));
        expectedAliveCells.add(new Cell(2, 1));
        expectedAliveCells.add(new Cell(1, 4));
        expectedAliveCells.add(new Cell(3, 3));

        Grid grid = new InputParser().createGrid(seedPattern);
        List<Cell> aliveCells = grid.tick();

        assertEquals(expectedAliveCells, aliveCells);
    }

}



