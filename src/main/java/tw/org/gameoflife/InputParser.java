package tw.org.gameoflife;

import tw.org.model.Cell;
import tw.org.model.Grid;

import java.util.ArrayList;

public class InputParser {
    public Grid createGrid(ArrayList<String> seedPattern) {
        ArrayList<Cell> aliveCells = new ArrayList<>();
        for(String inputItem : seedPattern){
            aliveCells.add(new CellParser().createCell(inputItem));
        }
        return new Grid(aliveCells);
    }
}
