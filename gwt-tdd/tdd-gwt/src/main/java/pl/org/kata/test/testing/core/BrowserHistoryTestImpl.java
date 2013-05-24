package pl.org.kata.test.testing.core;

import pl.org.kata.test.client.core.IBrowserHistory;
import java.util.Stack;

import javax.inject.Inject;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.HandlerRegistration;


public class BrowserHistoryTestImpl implements IBrowserHistory {

  private Stack<String> browserHistory = new Stack<String>();
  private Stack<String> forwardStack = new Stack<String>();
  private EventBus eventBus;


  @Inject
  public BrowserHistoryTestImpl(EventBus eventBus) {
    this.eventBus = eventBus;
  }


  @Override
  public String getToken() {

    if (browserHistory.empty()) {
      return null;
    } else {
      return browserHistory.peek();
    }

  }


  @Override
  public void newItem(String requestToken, boolean issueEvent) {
    browserHistory.push(requestToken);
    forwardStack.clear();

    if (issueEvent) {
      fireHistoryChangedEvent();
    }
  }


  @Override
  public void back() {
    if (browserHistory.size() > 1) {
      String fromHistory = browserHistory.pop();
      forwardStack.push(fromHistory);
      fireHistoryChangedEvent();
    }
  }


  @Override
  public void forward() {
    if (!forwardStack.empty()) {
      String nextToken = forwardStack.pop();
      browserHistory.push(nextToken);
      fireHistoryChangedEvent();
    }
  }


  private void fireHistoryChangedEvent() {
    ValueChangeEvent.fire(this, getToken());
  }


  @Override
  public HandlerRegistration addValueChangeHandler(ValueChangeHandler<String> handler) {
    return eventBus.addHandler(ValueChangeEvent.getType(), handler);
  }


  @Override
  public void fireEvent(GwtEvent<?> event) {
    eventBus.fireEvent(event);
  }


  @Override
  public void fireCurrentHistoryState() {
    fireHistoryChangedEvent();
  }
}