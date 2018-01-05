import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.Random;
import java.util.Collection;
import java.util.Collections;

public class Habitations extends Units<Habitation>{
  private int seuil;

  // constructor
  public Habitations(ArrayList<Habitation> tabHabitations, int seuil, int nbHabLine, int nbHabColumn){
    super(tabHabitations, nbHabLine, nbHabColumn);
    this.seuil = seuil;
  }

  /**
  *Define the next state of the entire board.
  */
  public void nextState(){
    // we register every habitation that will change of state
    // useful to avoid changes "à la volée"
    ArrayList<Habitation> willChange = new ArrayList<Habitation>();
    ArrayList<Habitation> freeCells = new ArrayList<Habitation>();
    for(Habitation hab : this.getBoard()){
      if (hab.getState() != 0){
        int nbVoisin = computeNbVoisin(hab);
        if (nbVoisin >= seuil){
          willChange.add(hab);
        }
      }else{
        freeCells.add(hab);
      }
    }
    // we actually change the state of the needed habitations
    for (int i = 0; i < willChange.size(); i ++){
      int random = new Random().nextInt(freeCells.size());
      willChange.get(i).changeState(willChange.get(i), freeCells.get(random));
      freeCells.remove(random);
    }
  }


  /**
  *Return the number of neighbours for hab.
  */
  public int computeNbVoisin(Habitation hab){
    int nbVoisin = 0;
    int line = hab.getLine();
    int column = hab.getColumn();
    int nbCellLine = this.getNbCellLine();
    int nbCellColumn = this.getNbCellColumn();
    Map<String, Integer> dicVoisins = new HashMap<String, Integer>();
    for (int j = column - 1 ; j < column + 2; j ++){
      for (int k = line - 1; k < line + 2; k ++){
        if (k >= 0 && j >= 0 && k < nbCellColumn && j < nbCellLine){
          Habitation habVoisin = this.getBoard().get(j*nbCellLine + k);
          if((j != column || k != line) && habVoisin.getState() != 0 && habVoisin.getState() != hab.getState()){
            String key = Integer.toString(habVoisin.getState());
            if (dicVoisins.containsKey(key)){
              dicVoisins.put(key, dicVoisins.get(key) + 1);
            }else{
              dicVoisins.put(key, 1);
            }
          }
        }
      }
    }
    Collection<Integer> c = dicVoisins.values();
    if (!c.isEmpty()){
      nbVoisin = Collections.max(c);
    }
    return nbVoisin;
  }
}
