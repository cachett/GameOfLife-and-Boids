import java.util.ArrayList;
import java.util.TreeSet;

public class EventManager{
  private long currentDate;
  private TreeSet<Event> events;

  public EventManager(){
    this.currentDate = 0;
    events = new TreeSet<Event>();
  }

  public void addEvent(Event event){
    events.add(event);
  }

  public boolean isFinished(){
    return events.isEmpty();
  }

  public void next(){
    currentDate++;
    while((!isFinished()) && events.first().getDate() < currentDate ){
      events.pollFirst().execute();
    }
  }

  public void restart(){
    this.currentDate = 0;
    events.clear();
  }


}
