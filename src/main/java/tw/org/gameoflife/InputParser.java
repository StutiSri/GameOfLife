package tw.org.gameoflife;

import tw.org.model.Cell;
import tw.org.model.Universe;

import java.util.ArrayList;

public class InputParser {
    public Universe createGrid(ArrayList<String> seedPattern) {
        ArrayList<Cell> aliveCells = new ArrayList<>();
        for(String inputItem : seedPattern){
            aliveCells.add(new CellParser().createCell(inputItem));
        }
        return new Universe(aliveCells);
    }
}
