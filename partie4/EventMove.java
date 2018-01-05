import java.util.ArrayList;

public class  EventMove extends Event{
  ArrayList<Boid> boids;

  public EventMove(long date, EventManager eventManager, ArrayList<Boid> boids){
    super(date, eventManager);
    this.boids = boids;
  }


  @Override
  public void execute(){
    /*This require two loop to avoid wrong result */
    for (Boid b: boids){
      if (b.getClass() == Boid.class){
        b.flock(boids); //Compute forces for each boids
      }
    }
    for (Boid b: boids){
      if (b.getClass() == Boid.class){
        b.update(); // Apply computed forces to each boids
      }
    }

    EventMove nextEvent = new EventMove(this.getDate()+1, eventManager, boids);
    eventManager.addEvent(nextEvent);
  }
}
