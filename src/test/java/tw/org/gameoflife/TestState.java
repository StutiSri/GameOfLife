package tw.org.gameoflife;

import tw.org.model.Grid;
import tw.org.model.State;

public class TestState extends State {

    public TestState(Grid grid) {
        super(grid);
    }

    @Override
    public boolean equals(Object obj) {
        return obj.toString().equals(super.toString());
    }
}
