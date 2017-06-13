package tw.org.model;


import java.util.ArrayList;

public class Universe {
    private final Grid grid;

    public Universe(Grid grid) {

        this.grid = grid;
    }

    public Grid tick(){
       // ArrayList<AliveCell> newAliveCells = new StateChanger().bringToLife
                //(grid);
        return grid;
    }
}
