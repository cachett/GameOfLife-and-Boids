abstract class Unit implements Cloneable{
  private final int nbStates;
  private int state;
  private int column;
  private int line;

  /**
  *Constructor Unit.
  *@param nbStates
  *       The number of state that the cell could take.
  *@param state
  *       The actual state of a cell.
  *@param colum
  *       The column where the cell is located.
  *@param line
  *       The line where the cell is located.
  */

  public Unit(int nbStates, int state, int column, int line){
    if ((state < 0) || (state > nbStates)){
      throw new IllegalArgumentException("entrer un état correct");
    }
    this.nbStates = nbStates;
    this.state =  state;
    this.column = column;
    this.line = line;
  }

  /**
  *Creation of a cell by coping another one.
  *@param Unit
  *        The specific cell that will be copied.
  */
  public Unit(Unit unit){
    this.nbStates = unit.getNbStates();
    this.state =  unit.getState();
    this.column = unit.getColumn();
    this.line = unit.getLine();
  }

  /**
  * Set a state of a cell.
  *@param state
  *         The state that will be affected to the cell.
  *@return column
  *       The column of the cell on the simulator interface..
  */
  public void setState(int state){
    this.state = state;
  }

  /**
  * Give us the column where the cell is located.
  *@return column
  *       The column of the cell on the simulator interface.
  */
  public int getColumn(){
    return this.column;
  }

  /**
  * Give us the line where the cell is located.
  *@return line
  *       The line of the cell on the simulator interface.
  */
  public int getLine(){
    return this.line;
  }

  /**
  * Give us the actual state of the cell.
  *@return state
  *       The actual state of the cell.
  */
  public int getState(){
    return this.state;
  }

  /**
  * Give us the number of state possible for a specific kind of cell.
  *@return nbStates
  *       The number of different state possible for the cell.
  */
  public int getNbStates(){
    return this.nbStates;
  }

  /**
  *Clone an unit
  */
  public Object clone(){
    Object o = null;
    try{
      o = super.clone();
    } catch(CloneNotSupportedException cnse) {
      cnse.printStackTrace(System.err);
    }
    return o;
  }

  @Override
  public String toString(){
    String res = "{ State :" + state + " Colum:" + column +" Line:" + line + "\n" ;
    return res;
  }
}
