//package tw.org.gameoflife;
//
//import tw.org.model.AliveCell;
//import tw.org.model.Cell;
//import tw.org.model.DeadCell;
//import tw.org.model.Grid;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.Map;
//
//public class StateChanger {
//    public ArrayList<AliveCell> bringToLife(Grid grid) {
//        Map<Cell, Integer> aliveCellToNeighboursMap = new HashMap<>();
//
//        ArrayList<Cell> existingAliveCells = grid.getAliveCells();
//        Integer numberOfNeighbours;
//        for(Cell aliveCell : existingAliveCells){
//            for (int changeInRow = -1; changeInRow <= 1; changeInRow++) {
//                for (int changeInColumn = -1; changeInColumn <=1 ; changeInColumn++){
//                    Cell expectedAliveCell = new AliveCell(aliveCell.getRow() +
//                            changeInRow,
//                            aliveCell.getColumn() + changeInColumn);
//                    if(isValidDeadNeightbour(expectedAliveCell, existingAliveCells)){
//                        numberOfNeighbours = aliveCellToNeighboursMap.get(expectedAliveCell);
//
//                    }
//
//
//                }
//            }
//        }
//    }
//}
