package tw.org.gameoflife;

import org.junit.Test;
import tw.org.gameoflife.InputParser;
import tw.org.model.Cell;
import tw.org.model.TestUniverse;
import tw.org.model.Universe;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class UniverseTest {

    @Test
    public void shouldCreateGridForInput(){
        ArrayList<String> seedPattern = new ArrayList<>();
        seedPattern.add("1, 1");
        seedPattern.add("1, 2");
        seedPattern.add("2, 1");
        seedPattern.add("2, 2");
        Universe expectedUniverse = new TestUniverse(seedPattern);

        Universe universe = new InputParser().createGrid(seedPattern);

        assertEquals(expectedUniverse, universe);
    }

    @Test
    public void shouldCreateNextGeneration(){
        ArrayList<String> seedPattern = new ArrayList<>();
        seedPattern.add("0, 1");
        seedPattern.add("1, 1");
        seedPattern.add("1, 0");
        List<Cell> expectedNextGeneration = new ArrayList<>();
        expectedNextGeneration.add(new Cell(0,0));

        Universe universe = new InputParser().createGrid(seedPattern);
        List<Cell> nextGeneration = universe.createNextGeneration();

        assertEquals(expectedNextGeneration, nextGeneration);
    }

    @Test
    public void gridWithOnlyOneCellShouldDie(){
        ArrayList<String> seedPattern = new ArrayList<>();
        seedPattern.add("0, 1");

        Universe universe = new InputParser().createGrid(seedPattern);
        List<Cell> aliveCells = universe.tick();

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

        Universe universe = new InputParser().createGrid(seedPattern);
        List<Cell> aliveCells = universe.getExpectedAliveCells();

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

        Universe universe = new InputParser().createGrid(seedPattern);
        List<Cell> aliveCells = universe.getExpectedAliveCells();

        assertEquals(expectedAliveCells,aliveCells);
    }

    @Test
    public void shouldReturnTheStateOfTheSystemAfterOneTick(){
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

        Universe universe = new InputParser().createGrid(seedPattern);
        List<Cell> aliveCells = universe.tick();

        assertEquals(expectedAliveCells,aliveCells);
    }

}



