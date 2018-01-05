import java.util.ArrayList;
import java.util.TreeSet;

public class EventManager{
  private long currentDate;
  private TreeSet<Event> events;

  // constructor
  public EventManager(){
    this.currentDate = 0;
    events = new TreeSet<Event>();
  }

  // addition of a new event
  public void addEvent(Event event){
    events.add(event);
  }

  // return true if events is empty
  public boolean isFinished(){
    return events.isEmpty();
  }

  // execute every event that has an earlier date than currentDate
  public void next(){
    currentDate++;
    while((!events.isEmpty()) && events.first().getDate() < currentDate ){
      events.pollFirst().execute();
    }
  }

  // reinit the current event manager
  public void restart(){
    this.currentDate = 0;
    events.clear();
  }
}
