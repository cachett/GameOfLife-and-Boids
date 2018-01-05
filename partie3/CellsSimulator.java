import gui.Simulable;
import java.awt.Color;
import gui.Rectangle;
import gui.GUISimulator;
import java.util.ArrayList;

public class CellsSimulator extends Simulator{

  /**
  *Constructor CellsSimulator.
  *@param tabCells
  *       The arrayList that contains the set of cells in their initial state.
  *@param width
  *       Width of the simulator screen.
  *@param height
  *       Height of the simulator screen.
  *@param nbCellLine
  *       The number of cells per line.
  *@param nbCellColumn
  *       The number of cells per column.
  *@see Simulator
  */
  public CellsSimulator(int width, int height, ArrayList<Cell> tabCells, int nbCellLine, int nbCellColumn){
    super(width, height, new Cells(tabCells, nbCellLine, nbCellColumn), nbCellLine, nbCellColumn);
  }

  /**
  *Update the simulator interface.
  *@see Simulator#getHeight()
  *@see Simulator#getWidth()
  *@see Units#getOneT()
  *@see Unit#getState()
  */
  public void majGui(){
    gui.reset();
    for (int j = 0; j < nbCellLine; j++){
      for (int k = 0; k < nbCellColumn; k++){
        Cell cell = (Cell)cells.getOneT(j,k);
        int state = cell.getState();
        int tailleCellLine = this.getHeight()/nbCellLine;
        int tailleCellColumn = this.getWidth()/nbCellColumn;
        if (state == 1){
          gui.addGraphicalElement(
            new Rectangle(
              j*tailleCellLine+tailleCellLine/2, k*tailleCellColumn+tailleCellColumn/2, Color.decode("#FF77b4"), Color.decode("#00FF48"), tailleCellLine, tailleCellColumn));
        } else{
          gui.addGraphicalElement(
            new Rectangle(
              j*tailleCellLine+tailleCellLine/2, k*tailleCellColumn+tailleCellColumn/2, Color.decode("#FF77b4"), Color.decode("#000000"), tailleCellLine, tailleCellColumn));
        }
        }
      }
    }
  }
