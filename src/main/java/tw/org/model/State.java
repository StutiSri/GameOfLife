package tw.org.model;

public class State {

    public String state;

    public State(Grid grid){
        state = grid.toString();
    }

    @Override
    public String toString() {
        return state;
    }
}
