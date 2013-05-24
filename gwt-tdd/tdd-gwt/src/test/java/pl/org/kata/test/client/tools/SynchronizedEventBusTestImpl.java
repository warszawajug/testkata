package pl.org.kata.test.client.tools;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.google.gwt.event.shared.EventHandler;
import com.google.web.bindery.event.shared.Event;

/**
 * Najprostsza z możliwych implementacja EventBus.
 * Każdy fire oraz add nie jest zapisywany w kolejce lecz odpalany natychmiast
 *
 * @author Przemysław Gałązka
 * @since 15-05-2013
 */
public class SynchronizedEventBusTestImpl extends
    com.google.web.bindery.event.shared.EventBus {

  private HashMap<Event.Type, List> handlersByType
      = new HashMap<Event.Type, List>();


  @Override
  public void fireEvent(Event event) {

    List<EventHandler> eventHandlers = handlersByType.get(event.getAssociatedType());

    if (eventHandlers != null) {
      for (EventHandler handler : eventHandlers) {
        dispatchEvent(event, handler);
      }
    }
  }


  @Override
  public <H> com.google.web.bindery.event.shared.HandlerRegistration addHandler(Event.Type<H> type,
      H handler) {

    List handlers = handlersByType.get(type);

    if (handlers == null) {
      handlers = new ArrayList<EventHandler>();
      handlersByType.put(type, handlers);
    }

    handlers.add(handler);

    return new HandlerRegistrationTestImpl<H>(handler, handlers);
  }


  @Override
  public <H> com.google.web.bindery.event.shared.HandlerRegistration addHandlerToSource(
      Event.Type<H> type, Object source, H handler) {

    throw new RuntimeException("Not implemented");
  }


  @Override
  public void fireEventFromSource(Event<?> event, Object source) {
    throw new RuntimeException("Not implemented");
  }
}
