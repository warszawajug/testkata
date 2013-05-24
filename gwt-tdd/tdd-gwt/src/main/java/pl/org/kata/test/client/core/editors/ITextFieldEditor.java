package pl.org.kata.test.client.core.editors;

import com.google.gwt.editor.client.HasEditorErrors;
import com.google.gwt.editor.client.LeafValueEditor;
import com.google.gwt.user.client.ui.HasText;


/**
 * @author Przemys³aw Ga³±zka
 * @since 08-03-2013
 */
public interface ITextFieldEditor
    extends HasEditorErrors<String>, LeafValueEditor<String>, HasText {

}
