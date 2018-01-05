import gui.GUISimulator;
import java.util.concurrent.ThreadLocalRandom;
import java.util.ArrayList;

public class TestHabitationsSimulator{
  public static void main (String[] args){
    ArrayList<Habitation> tabHabs = new ArrayList<Habitation>();
    for (int i = 0; i < 50; i++){
      for (int j = 0; j < 50; j++){
        if ( (i + j) % 2 == 0){
          Habitation hab = new Habitation(5, ThreadLocalRandom.current().nextInt(1, 6), i, j);
          tabHabs.add(hab);
        }else{
          Habitation hab = new Habitation(5, 0, i, j);
          tabHabs.add(hab);
        }
      }
    }

    int seuil = 3;
    HabitationsSimulator habsSimulator = new HabitationsSimulator(750, 750, tabHabs, 50, 50, seuil);
    GUISimulator gui = habsSimulator.getGui();
    gui.setSimulable(habsSimulator);
  }
}
