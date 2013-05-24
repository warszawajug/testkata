package pl.org.kata.test.client.editors;

import pl.org.kata.test.client.model.Addresses;

import javax.inject.Inject;
import com.google.gwt.editor.client.Editor;


public class AddressesEditor implements Editor<Addresses> {

  @Inject public AddressDataEditor register;
  @Inject public AddressDataEditor mail;

}
