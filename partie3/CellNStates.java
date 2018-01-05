
class CellNStates extends Unit{

  /**
  *Constructor CellNStates.
  *@param nbStates
  *       The number of state that the cell could take.
  *@param state
  *       The actual state of a cell.
  *@param colum
  *       The column where the cell is located.
  *@param line
  *       The line where the cell is located.
  *@see Unit
  */

  public CellNStates(int nbStates, int state, int column, int line){
    super(nbStates, state, column, line);
  }

  /**
  *Creation of a cell by coping another one.
  *@param cell
  *        The specific cell that will be copied.
  *@see Unit
  */
  public CellNStates(CellNStates cell){
    super(cell);
  }

  /**
  *Change the state (dead or alive) of one cell
  *@see Unit#getState()
  *@see Unit#setState()
  */
  public void changeState(){
    int state = this.getState();
    state = state % this.getNbStates() + 1;
    this.setState(state);
  }
}
