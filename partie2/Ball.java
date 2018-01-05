import java.util.ArrayList;
import java.lang.Math;
import java.util.Random;

/**
*<b> This class Ball represent a Ball which is able to bounce on an other Ball or borders. <\b>
*<p>
*A ball is caracterised by :

* <li>A vector to indicate his position.</li>
* <li>A vector to indicate his velocity.</li>

*<\p>

*/

class Ball {
    private static final Random r = new Random();
    private Vector location, velocity;
    private final int width, height;


    /**
    *Constructor Ball.
    *@param x
    *       The abscissa of the ball.
    *@param y
    *       The ordinate of the ball.
    *@param width
    *       Width of the simulator screen.
    *@param height
    *       Height of the simulator screen.
    *@see Vector
    */
    public Ball(double x, double y, int width, int height) {
        velocity = new Vector(r.nextInt(6) + 1, r.nextInt(6) - 2);
        location = new Vector(x, y);
        this.width = width;
        this.height = height;
    }

    /**
    *Constructor Ball from another ball.
    *@param ball
    *       The ball that will be copied.
    *@see Vector
    */
    public Ball(Ball ball){
      this.velocity = new Vector(ball.velocity);
      this.location = new Vector(ball.location);
      this.height = ball.height;
      this.width = ball.width;
    }

    /**
    *Translate every ball of an array : update the velocity vector of each ball.
    *@param balls
    *           The array of ball that needed to be translate.
    *@see Vector
    */
    public void translate(ArrayList<Ball> balls){
      updateVelocityBorder(); // Manage the bouncing with border
      updateVelocityImpact(balls); //Manage the boucing with an other ball.
      location.add(velocity); //translation
    }

    /**
    * Switch vector's direction if the ball will meet a border on the next iteration.
    */
    public void updateVelocityBorder(){
      if (location.x + velocity.x  + 25 > width || location.x + velocity.x - 25 < 0){
        velocity.x *= -1;
      }
      if (location.y + velocity.y + 25 > height || location.y + velocity.y - 25 < 0){
        velocity.y *= -1;
      }
    }

    /**
    *Modify Ball's velocity if it will bounce with another ball on the next iteration.
    */
    public void updateVelocityImpact(ArrayList<Ball> balls){
      Vector ballLeft, ballRight, dirLeft, dirRight;
      for (Ball b: balls){
        if (Vector.dist(Vector.add(b.getLocation(), b.getVelocity()), Vector.add(location, velocity)) <= 52 && b != this){
          //IMPACT
          ballLeft = new Vector(b.getLocation());
          ballRight =  new Vector(location);
          dirLeft = new Vector(b.getVelocity());
          dirRight = new Vector(velocity);
          Vector impactDir = Vector.sub(ballRight, ballLeft);
          impactDir.normalize();
          double normImpact = Math.abs(impactDir.dot(dirLeft));
          double normImpact2 = Math.abs(impactDir.dot(dirRight));
          impactDir.mult((normImpact+ normImpact2)*0.8); // It would have been more correct to multiply by 0.5 but 0.8 make the simulation more dynamic
          Vector velocityB = b.getVelocity();
          if (b.getLocation().x < location.x){
            if(impactDir.x >0){
              velocity.add(impactDir);
              velocityB.sub(impactDir);
            }else{
              velocity.sub(impactDir);
              velocityB.add(impactDir);
            }
          }else{
            if (impactDir.x>0){
              velocity.sub(impactDir);
              velocityB.add(impactDir);
            }else{
              velocity.add(impactDir);
              velocityB.sub(impactDir);
            }
          }
        }
      }
    }

    /**
    * Give us the location of one ball.
    *@return v
    *       The vector position of the ball.
    */
    public Vector getLocation(){
      return location;
    }

    /**
    * Give us the velocity of one ball.
    *@return v
    *       The vector velocity of the ball.
    */
    public Vector getVelocity(){
      return velocity;
    }

    @Override
    public String toString(){
      String res = "Location: " + location +  "Velocity: " + velocity ;
      return res;
    }

  }
