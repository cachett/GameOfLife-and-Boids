import java.util.ArrayList;
import gui.Simulable;
import gui.GUISimulator;

class MultiSimulator extends BoidsSimulator{

  public MultiSimulator(int width, int height, int nbBoids, int nbBoids2) {
      super(width, height, nbBoids);
      for (int i = 0; i < nbBoids2; i++){
        Boid2 newBoid = new Boid2(r.nextInt(width+1),r.nextInt(height+1), width, height);
        boids.add(newBoid);
        boidsInit.add(new Boid2(newBoid));
      }
      EventMove2 firstEventMove2 = new EventMove2(0, eventManager, boids);
      eventManager.addEvent(firstEventMove2);
      initGui();
  }

  @Override
  public void restart(){
    /* Re init the ArrayList boids and the events */
    for (int i = 0; i< boids.size(); i++){
      if (boidsInit.get(i).getClass() == Boid.class){
        boids.set(i, new Boid(boidsInit.get(i)));
      }else{
        boids.set(i, new Boid2(boidsInit.get(i)));
      }
    }
    eventManager.restart();
    eventManager.addEvent(new EventMove(0, eventManager, boids));
    eventManager.addEvent(new EventMove2(0, eventManager, boids));
    updateGui();
  }

}
