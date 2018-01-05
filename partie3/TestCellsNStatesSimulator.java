import gui.GUISimulator;
import java.util.concurrent.ThreadLocalRandom;
import java.util.ArrayList;

public class TestCellsNStatesSimulator{
  public static void main (String[] args){
    ArrayList<CellNStates> tabCells = new ArrayList<CellNStates>();
    for (int i = 0; i < 10; i++){
      for (int j = 0; j < 10; j++){
        CellNStates cell = new CellNStates(5, ThreadLocalRandom.current().nextInt(1, 6), i, j);
        tabCells.add(cell);
      }
    }
    CellsNStatesSimulator cellsSimulator = new CellsNStatesSimulator(500, 500, tabCells, 10, 10);
    GUISimulator gui = cellsSimulator.getGui();
    gui.setSimulable(cellsSimulator);
  }
}
