import java.awt.Point;
import gui.Simulable;
import java.util.ArrayList;
import gui.Oval;
import java.awt.Color;
import gui.GUISimulator;
import java.util.concurrent.ThreadLocalRandom;


/**
*<b> This class BallsSimulator display the balls and their movements on the simulator screen. <\b>
*<p>
*To do that, we need:

* <li>A GUISimulator.</li>
* <li>A set of balls.</li>

*<\p>

*/

public class BallsSimulator implements Simulable {
  private Balls balls;
  private GUISimulator gui;

  /**
  *Constructor BallsSimulator.
  *@param nbBalls
  *       The number of ball in the set.
  *@param width
  *       Width of the simulator screen.
  *@param height
  *       Height of the simulator screen.
  *@see Balls
  */
  public BallsSimulator(int nbBalls, int width, int height){
    if (nbBalls <=0 || width <= 0 || height <= 0){
      throw new IllegalArgumentException("Checkez les arguments du constructeur BallsSimulator");
    }
    Point tabCoordInit[] = new Point[nbBalls];
    for (int i = 0; i < nbBalls; i++){
      tabCoordInit[i] = new Point(ThreadLocalRandom.current().nextInt(0, width + 1), ThreadLocalRandom.current().nextInt(0, height + 1));
    }
    balls = new Balls(tabCoordInit, width, height);
    gui = new GUISimulator(width, height, Color.BLACK);
    majGui();
  }

  /**
  * Called when the button "Suivant" is pushed.
  *@see Balls
  */
  @Override
  public void next(){
    balls.translate();
    majGui();
  }

  /**
  *Called when the button "Debut" is pushed.
  *Simulator must came back in the initial state.
  *@see Balls
  */
  @Override
  public void restart(){
    balls.reInit();
    majGui();
  }

  /**
  *Update the simulator interface.
  *@see Balls#getBalls()
  *@see Ball#getLocation()
  */
  public void majGui(){
    gui.reset();
    ArrayList<Ball> ballsArray = balls.getBalls();
    for (Ball b: ballsArray){
      Vector location = b.getLocation();
      gui.addGraphicalElement(
        new Oval(
          (int) location.x, (int) location.y, Color.decode("#FF77b4"), Color.decode("#00FF48"), 50));
    }
  }

  /**
  *Give us the GUISimulator used.
  *@return GUISimulator
  *           The GUISimulator used.
  */
  public GUISimulator getGui(){
    return this.gui;
  }

}
