class Cell extends Unit{

  /**
  *Constructor Cell.
  *@param state
  *       The state of the ball : 1 for alive, 2 for dead.
  *@param colum
  *       The column where the cell is located.
  *@param line
  *       The line where the cell is located.
  *@see Unit
  */
  public Cell(int state, int column, int line){
    super(2, state, column, line);
  }

  /**
  *Creation of a cell by coping another one.
  *@see Unit
  */
  public Cell(Cell cell){
    super(cell);
  }

  /**
  *Change the state (dead or alive) of one cell
  *@see Unit#getState()
  *@see Unit#setState()
  */
  public void changeState(){
    if (this.getState() == 2){
      this.setState(1);
    }else{
      this.setState(2);
    }
  }
}
