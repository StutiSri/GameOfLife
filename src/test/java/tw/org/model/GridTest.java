package tw.org.model;

import org.junit.Test;
import tw.org.gameoflife.InputParser;

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
        expectedNextGeneration.add(new DeadCell(0,0));

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

        assertEquals(null,aliveCells);
    }
//    @Test
//    public void cellWithOnlyOneNeighbourShouldDie(){
//        ArrayList<String> seedPattern = new ArrayList<>();
//        seedPattern.add("0, 0");
//        seedPattern.add("1, 1");
//        seedPattern.add("1, 2");
//        seedPattern.add("2, 2");
//
//        List<Cell> expectedAliveCells = new ArrayList<>();
//        expectedAliveCells.add(new AliveCell(1,1));
//        expectedAliveCells.add(new AliveCell(1,2));
//        expectedAliveCells.add(new AliveCell(2,2));
//
//        Grid grid = new InputParser().createGrid(seedPattern);
//        List<Cell> aliveCells = grid.tick();
//
//        assertEquals(expectedAliveCells,aliveCells);
//    }

}



