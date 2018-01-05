import gui.Simulable;
import java.awt.Color;
import gui.Rectangle;
import gui.GUISimulator;
import java.util.ArrayList;

abstract class Simulator<T extends Units> implements Simulable{
  protected T cells;
  protected GUISimulator gui;
  protected int nbCellLine;
  protected int nbCellColumn;
  protected EventManager eventManager;
  protected int width, height;

  /**
  *Constructor Simulator.
  *@param T
  *       The arrayList which represent the set of cells.
  *@param width
  *       Width of the simulator screen.
  *@param height
  *       Height of the simulator screen.
  *@param nbCellLine
  *       The number of cells per line.
  *@param nbCellColumn
  *       The number of cells per column.
  *@see EventManager
  *@see EventChangeColor

  */
  public Simulator(int width, int height, T cells, int nbCellLine, int nbCellColumn){
    this.nbCellLine = nbCellLine;
    this.nbCellColumn = nbCellColumn;
    if (width <= 0 || height <= 0){
      throw new IllegalArgumentException("Merci de définir une largeur et une hauteur strictement positives pour la fenêtre graphique");
    }
    this.cells = cells;
    this.width = width;
    this.height = height;
    gui = new GUISimulator(width, height, Color.BLACK);
    eventManager = new EventManager();
    EventChangeColor<T> firstEvent = new EventChangeColor<T>(0, cells, eventManager);
    eventManager.addEvent(firstEvent);
    majGui();
  }

  /**
  *Update the simulator interface.
  *Needed and overrided in each event.
  */
  public abstract void majGui();

  /**
  * Called when the button "Suivant" is pushed.
  *Used by Gui to go to the next state.
  *@see CellsSimulator#majGui() or CellsNState#majGui()
  *@see EventManager#next()
  */
  public void next(){
    eventManager.next();
    majGui();
  }

  /**
  *Called when the button "Debut" is pushed.
  *Simulator must came back in the initial state.
  *@see Units#reInit()
  *@see EventManager
  *@see CellsSimulator#majGui() or CellsNState#majGui()
  */
  public void restart(){
    cells.reInit();
    eventManager.restart();
    eventManager.addEvent(new EventChangeColor<T>(0, cells, eventManager));
    majGui();
  }

  /**
  *Give us the number of cells per column in the board.
  *@return nbCellColumn
  *       the number of cells per column in the board.
  */
  public int getNbCellColumn(){
    return this.nbCellColumn;
  }

  /**
  *Give us the number of cells per line in the board.
  *@return nbCellLine
  *       the number of cells per line in the board.
  */
  public int getNbCellLine(){
    return this.nbCellLine;
  }

  /**
  *Give us the GUISimulator used.
  *@return GUISimulator
  *           The GUISimulator used.
  */
  public GUISimulator getGui(){
    return this.gui;
  }

  /**
  *Give us the height the board.
  *@return height
  *       The height of the board.
  */
  public int getHeight(){
    return this.height;
  }

  /**
  *Give us the Width the board.
  *@return height
  *       The width of the board.
  */
  public int getWidth(){
    return this.width;
  }
}
