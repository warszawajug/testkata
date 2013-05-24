package pl.org.kata.test.client.core.editors;

import pl.org.kata.test.client.core.editors.impl.TextFieldEditor;

import com.google.gwt.inject.client.AbstractGinModule;

/**
 * @author Przemys³aw Ga³±zka
 * @since 08-03-2013
 */
public class EditorsModule extends AbstractGinModule {


  @Override
  protected void configure() {
    bind(ITextFieldEditor.class).to(TextFieldEditor.class);
  }
}
