import gui.GUISimulator;
import java.util.concurrent.ThreadLocalRandom;
import java.util.ArrayList;

public class TestCellsSimulator{
  public static void main (String[] args){
    ArrayList<Cell> tabCells = new ArrayList<Cell>();
    for (int i = 0; i< 10; i++){
      for (int j = 0; j < 10; j++){
        Cell cell = new Cell(ThreadLocalRandom.current().nextInt(1, 3), i, j);
        tabCells.add(cell);
      }
    }
    CellsSimulator cellsSimulator = new CellsSimulator(500, 500, tabCells, 10, 10);
    GUISimulator gui = cellsSimulator.getGui();
    gui.setSimulable(cellsSimulator);
  }
}
