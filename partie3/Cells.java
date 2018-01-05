import java.util.ArrayList;

public class Cells extends Units<Cell>{

  /**
  *Constructor Cells.
  *@param tabCells
  *       An arrayList of cells in their initial state.
  *@param nbCellLine
  *       The number of cells per line.
  *@param nbCellColumn
  *       The number of cells per column.
  *@see Units
  */
  public Cells(ArrayList<Cell> tabCells, int nbCellLine, int nbCellColumn){
    super(tabCells, nbCellLine, nbCellColumn);
  }

  /**
  *Define the next state of the entire board.
  *@see Unit#getState()
  *@see Cell#changeState()
  */
  public void nextState(){
    //we register every cell that will change of state
    //useful to avoid changes "à la volée"
    ArrayList<Cell> willChange = new ArrayList<Cell>();
    for (Cell cell : this.getBoard()){
      int nbVoisin = computeNbVoisin(cell);
      if ((cell.getState() == 2 && nbVoisin == 3) || (cell.getState() == 1 && nbVoisin != 2 && nbVoisin != 3) ){
        willChange.add(cell);
      }
    }
    for (int i = 0; i<willChange.size(); i++){
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
  public int computeNbVoisin(Cell cell){
      int nbVoisin = 0;
      int line = cell.getLine();
      int column = cell.getColumn();
      int nbCellLine = this.getNbCellLine();
      int nbCellColumn = this.getNbCellColumn();
      //we check the state of the height neighbours
      for (int j = column -1 ; j<column +2; j++){
        for (int k= line -1; k<line+2; k++){
          if((j != column || k != line) && this.getBoard().get((((j%nbCellLine)+nbCellLine)%nbCellLine)*nbCellLine + ((k%nbCellColumn)+nbCellColumn)%nbCellColumn).getState() == 1){
            nbVoisin += 1;
          }
        }
      }
      return nbVoisin;
      }
  }
