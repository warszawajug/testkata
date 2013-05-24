package pl.org.kata.test.client.core;


import com.google.gwt.event.logical.shared.HasValueChangeHandlers;

/**
 * Interfejs ukrywający implementację {@link com.google.gwt.user.client.History}
 *
 * @author Przemysław Gałązka
 * @since 19-12-2012
 */
public interface IBrowserHistory extends HasValueChangeHandlers<String> {
  String getToken();

  void newItem(String requestToken, boolean issueEvent);

  void back();

  void forward();

  void fireCurrentHistoryState();
}