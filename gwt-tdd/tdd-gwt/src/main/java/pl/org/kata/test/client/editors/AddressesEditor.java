package pl.org.kata.test.client.editors;

import pl.org.kata.test.client.model.Addresses;

import javax.inject.Inject;
import com.google.gwt.editor.client.Editor;

/**
 * @author Przemys³aw Ga³±zka
 * @since 05-03-2013
 */
public class AddressesEditor implements Editor<Addresses> {

  @Inject
  public AddressDataEditor register;
  @Inject
  public AddressDataEditor mail;
}
