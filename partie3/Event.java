import java.util.TreeSet;

abstract class Event implements Comparable<Event>{
  private long date;
  private EventManager eventManager;

  // constructor
  public Event(long date, EventManager eventManager) {
    this.date = date;
    this.eventManager = eventManager;
  }

  // return the date
  public long getDate(){
    return date;
  }

  // return the eventManager
  public EventManager getEventManager(){
    return eventManager;
  }

  // needed and overrided in each event
  public abstract void execute();


  // useful to order the events
  @Override
  public int compareTo(Event event){
    return this.date > event.date ? 1 : -1;
  }
}
