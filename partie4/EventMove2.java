import java.util.ArrayList;

public class  EventMove2 extends Event{
  ArrayList<Boid> boids;

  public EventMove2(long date, EventManager eventManager, ArrayList<Boid> boids){
    super(date, eventManager);
    this.boids = boids;
  }


  @Override
  public void execute(){
    /* This require two loops to avoid wrong result */
    for (Boid b: boids){
      if (b.getClass() == Boid2.class){
        b.flock(boids); // Compute forces for each boid
      }
    }
    for (Boid b: boids){
      if (b.getClass() == Boid2.class){
        b.update(); // Apply computed forces
      }
    }

    EventMove2 nextEvent = new EventMove2(this.getDate()+2, eventManager, boids);
    eventManager.addEvent(nextEvent);
  }
}
