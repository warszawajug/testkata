package pl.org.kata.test.client.core.editors.impl;

import pl.org.kata.test.client.core.editors.ITextFieldEditor;
import java.util.List;

import com.google.gwt.editor.client.EditorError;
import com.google.gwt.user.client.ui.TextBox;

/**
 * @author Przemysław Gałązka
 * @since 24-05-2013
 */
public class TextFieldEditor extends TextBox implements ITextFieldEditor {

  @Override
  public void showErrors(List<EditorError> errors) {
    //TODO
  }
}
