class Habitation extends Unit{

  // constructor
  public Habitation(int nbStates, int state, int column, int line){
    super(nbStates, state, column, line);
  }

  /**
  *Copy
  */
  public Habitation(Habitation hab){
    super(hab);
  }

  /**
  *Exchange the state of two habitations
  */
  public void changeState(Habitation depart, Habitation arrivee){
    arrivee.setState(depart.getState());
    depart.setState(0);
  }
}
