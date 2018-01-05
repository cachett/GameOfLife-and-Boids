public class EventChangeColor<T extends Units> extends Event {
  private T cells;

  // constructor
  public EventChangeColor(long date, T cells, EventManager eventManager){
    super(date, eventManager);
    this.cells = cells;
  }

  // execution of this type of event, and addition of a new event
  @Override
  public void execute(){
    cells.nextState();
    EventChangeColor<T> nextEvent = new EventChangeColor<T>(this.getDate()+1, cells, this.getEventManager());
    this.getEventManager().addEvent(nextEvent);
  }
}
