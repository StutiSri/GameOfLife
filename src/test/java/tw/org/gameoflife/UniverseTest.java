package tw.org.gameoflife;

import org.junit.Test;
import tw.org.model.Grid;
import tw.org.model.State;
import tw.org.model.TestGrid;
import tw.org.model.Universe;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class UniverseTest {
    @Test
    public void shouldReturnNextState() {
        ArrayList<String> seedPattern = new ArrayList<>();
        seedPattern.add("1, 1");
        seedPattern.add("1, 2");
        seedPattern.add("2, 1");
        ArrayList<String> expectedPattern = new ArrayList<>();
        expectedPattern.add("1, 1");
        expectedPattern.add("1, 2");
        expectedPattern.add("2, 1");
        expectedPattern.add("2, 2");
        TestGrid testGrid = new TestGrid(expectedPattern);
        TestState expectedState = new TestState(testGrid);

        Universe universe = new Universe(seedPattern);
        State state = universe.getNextState();

        assertEquals(expectedState, state);
    }
}
