import gui.Simulable;
import java.awt.Color;
import gui.Rectangle;
import gui.GUISimulator;
import java.util.ArrayList;

public class CellsNStatesSimulator extends Simulator implements Simulable{

  /**
  *Constructor CellsNStatesSimulator.
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
  public CellsNStatesSimulator(int width, int height, ArrayList<CellNStates> tabCells, int nbCellLine, int nbCellColumn){
    super(width, height, new CellsNStates(tabCells, nbCellLine, nbCellColumn), nbCellLine, nbCellColumn);
  }

  /**
  *Update the simulator interface.
  *@see Simulator#getHeight()
  *@see Simulator#getWidth()
  *@see Simulator#getNbCellLine()
  *@see Simulator#getNbCellColumn()
  *@see Simulator#getGui()
  *@see Units#getOneT()
  *@see Unit#getState()
  *@see Unit#getNbStates()
  */
  public void majGui(){
    if (cells != null){
      GUISimulator gui = this.getGui();
      int nbCellLine = this.getNbCellLine();
      int nbCellColumn = this.getNbCellColumn();
      int tailleCellLine = this.getHeight()/nbCellLine;
      int tailleCellColumn = this.getWidth()/nbCellColumn;
      gui.reset();
      for (int j = 0; j < nbCellLine; j++){
        for (int k = 0; k < nbCellColumn; k++){
          CellNStates cell = (CellNStates)cells.getOneT(j,k);
          int state = cell.getState();
          int rgb = (255*state)/cell.getNbStates();
          String couleur = new String("#" + Integer.toHexString(rgb).toUpperCase() + Integer.toHexString(rgb).toUpperCase() + Integer.toHexString(rgb).toUpperCase());
          gui.addGraphicalElement(
            new Rectangle(
              j*tailleCellLine + tailleCellLine/2, k*tailleCellColumn + tailleCellColumn/2,
              Color.decode("#FF77b4"), Color.decode(couleur), tailleCellLine, tailleCellColumn));
          }
        }
      }
    }
  }
