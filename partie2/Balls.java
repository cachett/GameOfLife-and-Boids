import java.awt.Point;
import java.util.ArrayList;

/**
*<b> This class Balls represent a set of balls. <\b>
*<p>
*A set of balls is caracterised by :

* <li>An array of balls in their initial position.</li>
* <li>An array of balls in another position, when they have already moved.</li>

*<\p>

*/

public class Balls {
  private ArrayList<Ball> balls;
  private ArrayList<Ball> ballsInit;

  /**
  *Constructor Balls.
  *@param tabCoordInit
  *       An array of point which represent the initial position of each ball.
  *@param width
  *       Width of the simulator screen.
  *@param height
  *       Height of the simulator screen.
  *@see Point
  */
  public Balls(Point tabCoordInit[], int width, int height) {
    if (tabCoordInit.length == 0 || width <=0 || height <= 0){
      throw new IllegalArgumentException("Arguments du constructeur Balls non correctes");
    }
    balls = new ArrayList<Ball>();
    ballsInit = new ArrayList<Ball>();
    for (int i = 0; i < tabCoordInit.length; i++){
      Ball ball = new Ball(tabCoordInit[i].getX(), tabCoordInit[i].getY(), width, height);
      balls.add(ball);
      ballsInit.add(new Ball(ball));
    }
  }


  /**
  * Translate every ball of the array.
  *@see Ball#translate()
  */
  public void translate() {
    for (Ball b: balls) {
      b.translate(balls);
    }
  }

  /**
  *Reinitialise the position and the movement of each ball of the array.
  */
  public void reInit() {
    balls.clear();
    for (Ball b: ballsInit) {
      balls.add(new Ball(b));
    }
  }

  /**
  *Give us the set of balls.
  *@return balls
  *           The array list which contains all the balls with their current position.
  */
  public ArrayList<Ball> getBalls(){
    return balls;
  }

  @Override
  public String toString() {
    String res = "[";
    for (Ball b: balls) {
      res = res + b.toString();
    }
    res = res + "]";
    return res;
  }

}
