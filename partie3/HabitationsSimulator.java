import gui.Simulable;
import java.awt.Color;
import gui.Rectangle;
import gui.GUISimulator;
import java.util.ArrayList;

public class HabitationsSimulator extends Simulator<Habitations>{
  private int seuil;

  // constructor
  public HabitationsSimulator(int width, int height, ArrayList<Habitation> tabHabitations, int nbHabLine, int nbHabColumn, int seuil){
    super(width, height, new Habitations(tabHabitations, seuil, nbHabLine, nbHabColumn), nbHabLine, nbHabColumn);
    this.seuil = seuil;
    majGui();
  }

  // update the interface
  @Override
  public void majGui(){
    if (cells != null){
      GUISimulator gui = this.getGui();
      gui.reset();
      int nbHabLine = this.getNbCellLine();
      int nbHabColumn = this.getNbCellColumn();
      int tailleHabLine = this.getHeight()/nbHabLine;
      int tailleHabColumn = this.getWidth()/nbHabColumn;
      for (int j = 0; j < nbHabLine; j++){
        for (int k = 0; k < nbHabColumn; k++){
          Habitation hab = (Habitation)cells.getOneT(j,k);
          int state = hab.getState();
          int rgb = (255*state)/hab.getNbStates();
          String couleur = new String("#" + Integer.toHexString(rgb).toUpperCase() + Integer.toHexString(rgb).toUpperCase() + Integer.toHexString(rgb).toUpperCase());
          gui.addGraphicalElement(
            new Rectangle(
              j*tailleHabLine + tailleHabLine/2, k*tailleHabColumn + tailleHabColumn/2,
              Color.decode("#FF77b4"), Color.decode(couleur), tailleHabLine, tailleHabColumn));
          }
        }
      }
    }
  }
