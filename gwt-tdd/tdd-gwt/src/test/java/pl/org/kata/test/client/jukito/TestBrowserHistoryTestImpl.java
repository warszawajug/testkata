package pl.org.kata.test.client.jukito;

import pl.org.kata.test.client.core.placemanager.IBrowserHistory;
import pl.org.kata.test.testing.core.BrowserHistoryTestImpl;

import javax.inject.Inject;
import org.jukito.JukitoModule;
import org.jukito.JukitoRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.SimpleEventBus;

import static org.hamcrest.core.Is.*;
import static org.junit.Assert.*;


@RunWith(JukitoRunner.class)
public class TestBrowserHistoryTestImpl {


  @Inject
  IBrowserHistory browserHistory;


  @Test
  public void shouldRegisterUrlOnStack() throws Exception {

    //-------------------- GIVEN -------------------------------------------------------------------
    browserHistory.newItem("some url 1", false);
    browserHistory.newItem("some url 2", false);

    //-------------------- WHEN --------------------------------------------------------------------
    browserHistory.newItem("some url 3", false);

    //-------------------- THEN --------------------------------------------------------------------
    assertThat(browserHistory.getToken(), is("some url 3"));
  }


  @Test
  public void shouldSimulateBackButtonInBrowser() {

    //-------------------- GIVEN -------------------------------------------------------------------
    browserHistory.newItem("some url 1", false);
    browserHistory.newItem("some url 2", false);

    //-------------------- WHEN --------------------------------------------------------------------
    browserHistory.back();

    //-------------------- THEN --------------------------------------------------------------------
    assertThat(browserHistory.getToken(), is("some url 1"));
  }


  @Test
  public void shouldSimulateForwardButtonInBrowser() {

    //-------------------- GIVEN -------------------------------------------------------------------
    browserHistory.newItem("some url 1", false);
    browserHistory.newItem("some url 2", false);

    //-------------------- WHEN --------------------------------------------------------------------
    browserHistory.back();
    browserHistory.forward();

    //-------------------- THEN --------------------------------------------------------------------
    assertThat(browserHistory.getToken(), is("some url 2"));
  }


  @Test
  public void shouldReturnNullIfNewTabOpened() throws Exception {

    //-------------------- GIVEN -------------------------------------------------------------------
    // nothing

    //-------------------- WHEN --------------------------------------------------------------------
    // nothing

    //-------------------- THEN --------------------------------------------------------------------
    assertNull(browserHistory.getToken());
  }


  @Test
  public void shouldStayOnTheSameUrlIfOneItemInHistory() throws Exception {

    //-------------------- GIVEN -------------------------------------------------------------------
    browserHistory.newItem("first item in history", false);

    //-------------------- WHEN --------------------------------------------------------------------
    browserHistory.back();

    //-------------------- THEN --------------------------------------------------------------------
    assertThat(browserHistory.getToken(), is("first item in history"));
  }


  @Test
  public void shouldStayOnTheSameUrlIfOneItemInHistory2() throws Exception {

    //-------------------- GIVEN -------------------------------------------------------------------
    browserHistory.newItem("first item in history", false);

    //-------------------- WHEN --------------------------------------------------------------------
    browserHistory.forward();

    //-------------------- THEN --------------------------------------------------------------------
    assertThat(browserHistory.getToken(), is("first item in history"));
  }


  public static class A extends JukitoModule {

    @Override
    protected void configureTest() {
      bind(EventBus.class).to(SimpleEventBus.class);
      bind(IBrowserHistory.class).to(BrowserHistoryTestImpl.class);
    }
  }
}