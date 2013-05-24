/*
 * Copyright (c) 2000-2013, Efinity. All rights reserved.
 */

package pl.org.kata.test.client.tools;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.ui.HasText;

import static org.mockito.Mockito.*;

/**
 * @author Przemys³aw Ga³±zka
 * @since 21-01-2013
 */
public class MockButton implements HasClickHandlers, HasText {

  private ClickHandler handler;


  public void click() {
    handler.onClick(mock(ClickEvent.class));
  }


  @Override
  public HandlerRegistration addClickHandler(ClickHandler handler) {
    this.handler = handler;
    return null;
  }


  @Override
  public String getText() {
    return "mock button";
  }


  @Override
  public void setText(String text) {
  }


  @Override
  public void fireEvent(GwtEvent<?> event) {
  }
}
