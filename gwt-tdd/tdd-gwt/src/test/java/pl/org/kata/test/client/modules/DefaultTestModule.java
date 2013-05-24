/*
 * Copyright (c) 2000-2012, Efinity. All rights reserved.
 */

package pl.org.kata.test.client.modules;

import pl.org.kata.test.client.core.placemanager.IBrowserHistory;
import pl.org.kata.test.client.tools.MockButton;
import pl.org.kata.test.client.tools.SynchronizedEventBusTestImpl;
import pl.org.kata.test.testing.core.BrowserHistoryTestImpl;

import javax.inject.Singleton;
import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.web.bindery.event.shared.EventBus;

import static org.mockito.BDDMockito.*;

/**
 * Moduł bindujący podstawowe komponenty aplikacji dla testów JUnit
 *
 * @author Przemysław Gałązka
 * @since 20-12-2012
 */
public class DefaultTestModule extends AbstractModule {


  @Provides
  MockButton mockButton() {
    return new MockButton();
  }


  @Provides
  @Singleton
  IBrowserHistory createBrowserHistory(BrowserHistoryTestImpl browserHistoryTestImpl) {
    return spy(browserHistoryTestImpl);
  }


  @Provides
  @Singleton
  EventBus createEventBus(SynchronizedEventBusTestImpl eventBus) {
    return spy(eventBus);
  }


  @Override
  protected void configure() {
  }
}
