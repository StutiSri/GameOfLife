package tw.org.model;

import org.junit.Test;
import tw.org.gameoflife.CellParser;

import static junit.framework.Assert.assertEquals;
import static junit.framework.TestCase.assertTrue;

public class CellTest {
    @Test
    public void shouldCreateAliveCellFromInput(){
        AliveCell expectedCell = new AliveCell(1,1);

        Cell cell = new CellParser().createCell("1, 1");

        assertEquals(expectedCell, cell);
    }
}
