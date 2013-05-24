/*
 * Copyright (c) 2000-2012, Efinity. All rights reserved.
 */

package pl.org.kata.test.client.core.placemanager.impl;

import pl.org.kata.test.client.core.placemanager.IBrowserHistory;

import javax.inject.Inject;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.History;
import com.google.web.bindery.event.shared.EventBus;

public class BrowserHistory implements IBrowserHistory {

  private EventBus eventBus;


  @Inject
  public BrowserHistory(EventBus eventBus) {
    this.eventBus = eventBus;
  }


  @Override
  public String getToken() {
    return History.getToken();
  }


  @Override
  public void newItem(String requestToken, boolean issueEvent) {
    History.newItem(requestToken, issueEvent);
  }


  @Override
  public void back() {
    History.back();
  }


  @Override
  public void forward() {
    History.forward();
  }


  @Override
  public void fireCurrentHistoryState() {
    History.fireCurrentHistoryState();
  }


  @Override
  public HandlerRegistration addValueChangeHandler(ValueChangeHandler<String> handler) {
    return History.addValueChangeHandler(handler);
  }


  @Override
  public void fireEvent(GwtEvent<?> event) {
    eventBus.fireEvent(event);
  }
}

