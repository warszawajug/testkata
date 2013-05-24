package pl.org.kata.test.client.jukito;

import pl.org.kata.test.client.modules.DefaultTestModule;

import org.jukito.JukitoRunner;
import org.jukito.UseModules;
import org.junit.Test;
import org.junit.runner.RunWith;
import com.google.gwt.event.shared.EventHandler;
import com.google.gwt.event.shared.GwtEvent;
import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;
import com.google.web.bindery.event.shared.HandlerRegistration;

import static org.mockito.Mockito.*;

/**
 * @author Przemys³aw Ga³±zka
 * @since 16-05-2013
 */
@RunWith(JukitoRunner.class)
@UseModules(DefaultTestModule.class)
public class TestEventBusTestImpl {


  @Inject private EventBus eventBus;
  @Inject private SomeComponent someComponent;


  @Test
  public void shouldHandleStandardSubscription() {

    //-------------------- GIVEN -------------------------------------------------------------------
    eventBus.addHandler(SomeEvent.TYPE, new SomeHandler() {
      @Override
      public void addNewSubscription() {
        someComponent.hello();
      }
    });

    //-------------------- WHEN --------------------------------------------------------------------
    eventBus.fireEvent(new SomeEvent());

    //-------------------- THEN --------------------------------------------------------------------
    verify(someComponent).hello();
  }


  @Test
  public void shouldAddAndHandleSubscriptionInTheMiddleOfFire() {

    //-------------------- GIVEN -------------------------------------------------------------------
    eventBus.addHandler(SomeEvent.TYPE, new SomeHandler() {
      @Override
      public void addNewSubscription() {

        // here we add new subscription in the middle of fire method
        eventBus.addHandler(SomeInnerEvent.TYPE, new SomeInnerHandler() {
          @Override
          public void innerCall() {
            someComponent.hello();
          }
        });

        eventBus.fireEvent(new SomeInnerEvent());
      }
    });

    //-------------------- WHEN --------------------------------------------------------------------
    eventBus.fireEvent(new SomeEvent());


    //-------------------- THEN --------------------------------------------------------------------
    verify(someComponent).hello();
  }


  @Test
  public void shouldHandleStandardSubscriptionRemove() {

    //-------------------- GIVEN -------------------------------------------------------------------
    HandlerRegistration hr = eventBus.addHandler(SomeEvent.TYPE, new SomeHandler() {
      @Override
      public void addNewSubscription() {
        someComponent.hello();
      }
    });

    eventBus.fireEvent(new SomeEvent());

    //-------------------- WHEN --------------------------------------------------------------------
    hr.removeHandler();
    eventBus.fireEvent(new SomeEvent());


    //-------------------- THEN --------------------------------------------------------------------
    verify(someComponent, times(1)).hello();
  }


  public interface SomeComponent {
    void hello();

  }


  public interface SomeHandler extends EventHandler {
    void addNewSubscription();
  }

  public static class SomeEvent extends GwtEvent<SomeHandler> {

    public static final Type<SomeHandler> TYPE = new Type<SomeHandler>();


    @Override
    public Type getAssociatedType() {
      return TYPE;
    }


    @Override
    protected void dispatch(SomeHandler handler) {
      handler.addNewSubscription();
    }
  }

  // ----------------- some inner event and handler  ------------

  public interface SomeInnerHandler extends EventHandler {
    void innerCall();
  }

  public static class SomeInnerEvent extends GwtEvent<SomeInnerHandler> {

    public static final Type<SomeInnerHandler> TYPE = new Type<SomeInnerHandler>();


    @Override
    public Type getAssociatedType() {
      return TYPE;
    }


    @Override
    protected void dispatch(SomeInnerHandler handler) {
      handler.innerCall();
    }
  }

}
