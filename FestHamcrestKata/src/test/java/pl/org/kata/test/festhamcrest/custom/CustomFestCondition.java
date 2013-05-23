package pl.org.kata.test.festhamcrest.custom;

import org.fest.assertions.core.Condition;
import pl.org.kata.test.festhamcrest.Book;

/**
 * User: Michał Lewandowski
 * Date: 19.05.2013
 * Time: 14:54
 */
public class CustomFestCondition extends Condition<Book> {
    @Override
    public boolean matches(Book value) {
        //TODO Logic goes here
        return false;
    }

    public static CustomFestCondition valid(){
        return null;
        //TODO Return matcher
    }
}
