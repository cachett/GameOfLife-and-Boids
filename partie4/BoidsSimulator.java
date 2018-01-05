import gui.Simulable;
import java.awt.Color;
import gui.Oval;
import gui.GUISimulator;
import java.util.Random;
import java.util.ArrayList;


class BoidsSimulator implements Simulable{
    protected ArrayList<Boid> boids;
    protected ArrayList<Boid> boidsInit;
    protected static final Random r = new Random();
    protected GUISimulator gui;
    protected EventManager eventManager;

    //constructor 
    public BoidsSimulator(int width, int height, int nbBoids) {
        boids = new ArrayList<>();
        boidsInit = new ArrayList<>();
        for (int i = 0; i < nbBoids ;i++){
          Boid newBoid = new Boid(r.nextInt(width+1),r.nextInt(height+1), width, height);
          boids.add(newBoid);
          boidsInit.add(new Boid(newBoid));
        }
        eventManager = new EventManager();
        EventMove firstEventMove = new EventMove(0, eventManager, boids);
        eventManager.addEvent(firstEventMove);
        gui = new GUISimulator(width, height, Color.BLACK);
        initGui();
    }

    /**
    * Called when the button "Suivant" is pushed.
    */
    @Override
    public void next(){
      // two loops are necessary in order to avoid changes "à la volée"
      eventManager.next();
      updateGui();
    }

    /**
    *Called when the button "Debut" is pushed.
    *Simulator must came back in the initial state.
    */
    @Override
    public void restart(){
      for (int i = 0; i< boids.size(); i++){
        boids.set(i, new Boid(boidsInit.get(i)));
      }
      updateGui();
      eventManager.restart();
      eventManager.addEvent(new EventMove(0, eventManager, boids));
    }


    /**
    *Initialisation of the simulator
    */
    public void initGui(){
      gui.reset();
      for (Boid b: boids){
        String color = b.getClass() == Boid2.class ? "#0034F2" : "#F30013";
        int size = b.getClass() == Boid2.class ? 8 : 5;
        Vector location = b.getLocation();
        Vector velocity = new Vector(b.getVelocity());
        velocity.normalize();
        velocity.mult(5.5);
        gui.addGraphicalElement(new Oval((int)(location.x + velocity.x), (int)(location.y + velocity.y), Color.decode(color), Color.decode(color), 3, 3));
        gui.addGraphicalElement(new Oval((int)location.x, (int)location.y, Color.decode(color), Color.decode(color), size, size));
      }
    }

    /**
    *Update of the simulator,
    *when boids have moved.
    */
    public void updateGui(){
      gui.reset();
      int i = 0;
      for (Boid b: boids){
        String color = b.getClass() == Boid2.class ? "#0034F2" : "#F30013";
        int size = b.getClass() == Boid2.class ? 8 : 5;
        Vector location = b.getLocation();
        Vector velocity = new Vector(b.getVelocity());
        velocity.normalize();
        velocity.mult(5.5);
        gui.addGraphicalElement(new Oval((int)location.x, (int)location.y, Color.decode(color), Color.decode(color), size, size));
        gui.addGraphicalElement(new Oval((int)(location.x + velocity.x), (int)(location.y + velocity.y), Color.decode(color), Color.decode(color), 3, 3));
        i += 1;
      }
    }

    public GUISimulator getGui(){
      return gui;
    }



}
