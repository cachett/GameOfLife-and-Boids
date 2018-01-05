import java.util.TreeSet;



abstract class Event implements Comparable<Event>{
  private long date;
  protected EventManager eventManager;

  public Event(long date, EventManager eventManager) {
    this.date = date;
    this.eventManager = eventManager;
  }

  public long getDate(){
    return date;
  }

  public abstract void execute();


  @Override
  public int compareTo(Event event){
    return this.date > event.date ? 1 : -1;
  }
}
