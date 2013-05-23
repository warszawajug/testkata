package pl.org.kata.test.festhamcrest.custom;

import org.hamcrest.Description;
import org.hamcrest.Factory;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import pl.org.kata.test.festhamcrest.Book;

/**
 * User: Michał Lewandowski
 * Date: 20.05.2013
 * Time: 19:24
 */
public class CustomHamcrestMatcher extends TypeSafeMatcher<Book> {

    @Override
    protected boolean matchesSafely(Book book) {
        //TODO Logic goes here
        return false;
    }

    @Override
    public void describeTo(Description description) {
        //TODO Add something to description
    }

    @Factory
    public static Matcher<Book> validBook() {
        //TODO Return matcher
        return null;
    }

}
