import java.util.ArrayList;

abstract class Units<T extends Unit>{
  private ArrayList<T> boardInit;
  private ArrayList<T> board; //represente the actual state of the boar
  private int nbCellLine;
  private int nbCellColumn;

  /**
  *Constructor Units.
  *@param tabCells
  *       An arrayList of cells in their initial state.
  *@param nbCellLine
  *       The number of cells per line.
  *@param nbCellColumn
  *       The number of cells per column.
  *@see Unit#clone()
  */
  public Units(ArrayList<T> tabCells, int nbCellLine, int nbCellColumn){
    this.boardInit = tabCells;
    this.nbCellLine = nbCellLine;
    this.nbCellColumn = nbCellColumn;
    this.board = new ArrayList<T>();
    for (T t : tabCells){
      this.board.add((T)t.clone());
    }
  }

  /**
  *Define the next state of the board.
  */
  public abstract void nextState();

  /**
  *Reinitialisation of the board.
  *@see Unit#clone()
  */
  public void reInit(){
    this.board = new ArrayList<T>();
    for (T t : this.boardInit){
      this.board.add((T)t.clone());
    }
  }

  /**
  *Give us the element in the board witch is
  *in the line "line" and the column "column"
  *@return T
  *       The cell which is located in the line "line" and the column "column".
  */
  public T getOneT(int line, int column){
    return board.get(line*nbCellLine + column);
  }

  public ArrayList<T> getBoard(){
    return board;
  }

  public int getNbCellLine(){
    return nbCellLine;
  }

  public int getNbCellColumn(){
    return nbCellColumn;
  }
}
