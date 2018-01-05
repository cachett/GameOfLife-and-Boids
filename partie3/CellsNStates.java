import java.util.ArrayList;

public class CellsNStates extends Units<CellNStates>{

  /**
  *Constructor CellsNStates.
  *@param tabCells
  *       An arrayList of cells with N states in their initial state.
  *@param nbCellLine
  *       The number of cells per line.
  *@param nbCellColumn
  *       The number of cells per column.
  *@see Units
  */
  public CellsNStates(ArrayList<CellNStates> tabCells, int nbCellLine, int nbCellColumn){
    super(tabCells, nbCellLine, nbCellColumn);
  }

  /**
  *Define the next state of the entire board.
  *@see CellNStates#changeState()
  */
  public void nextState(){
    //we register every cell that will change of state
    //useful to avoid changes "à la volée"
    ArrayList<CellNStates> willChange = new ArrayList<CellNStates>();
    for (CellNStates cell : this.getBoard()){
      int nbVoisin = computeNbVoisin(cell);
      if (nbVoisin >= 3){
        willChange.add(cell);
      }
    }
    for (int i=0; i<willChange.size(); i++){
      willChange.get(i).changeState();
    }
  }

  /**
  *Compute the number of neighbours of one cell.
  *@param cell
  *       We are looking for the neighbours of this cell.
  *@return nbVoisin
  *       The number of neighbour of the cell.
  *@see Unit#getLine()
  *@see Unit#getColumn()
  *@see Unit#getState()
  */
  public int computeNbVoisin(CellNStates cell){
    int nbVoisin = 0;
    int line = cell.getLine();
    int column = cell.getColumn();
    int nbCellLine = this.getNbCellLine();
    int nbCellColumn = this.getNbCellColumn();
    for (int j = column -1 ; j<column +2; j++){
      for (int k= line -1; k<line+2; k++){
        if(j >= 0 && k >= 0 && j < nbCellLine && k < nbCellColumn && (j != column || k != line) && (this.getBoard().get(j*nbCellLine + k).getState() == cell.getState()%cell.getNbStates() + 1)){
          nbVoisin += 1;
        }
      }
    }
    return nbVoisin;
  }
}
