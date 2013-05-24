/*
 * Copyright (c) 2000-2012, Efinity. All rights reserved.
 */

package pl.org.kata.test.client.editors;

import pl.org.kata.test.client.core.editors.ITextFieldEditor;
import pl.org.kata.test.client.model.AddressDataProxy;

import javax.inject.Inject;
import com.google.gwt.editor.client.EditorDelegate;
import com.google.gwt.editor.client.ValueAwareEditor;


/**
 * @author Przemys³aw Ga³±zka
 * @since 19-06-2012
 */
public class AddressDataEditor implements ValueAwareEditor<AddressDataProxy> {

  @Inject public ITextFieldEditor street;

  @Inject public ITextFieldEditor houseNumber;

  @Inject public ITextFieldEditor apartmentNumber;

  @Inject public ITextFieldEditor zipcode;

  @Inject public ITextFieldEditor town;

  private AddressDataProxy value;


  public void clearValues() {
    street.setValue(null);
    houseNumber.setValue(null);
    apartmentNumber.setValue(null);
    town.setValue(null);
    zipcode.setValue(null);
  }


  @Override
  public void flush() {
  }


  @Override
  public void onPropertyChange(String... paths) {
  }


  @Override
  public void setValue(AddressDataProxy value) {
    this.value = value;
  }


  @Override
  public void setDelegate(EditorDelegate<AddressDataProxy> delegate) {
  }


  public AddressDataProxy getValue() {
    return value;
  }
}
