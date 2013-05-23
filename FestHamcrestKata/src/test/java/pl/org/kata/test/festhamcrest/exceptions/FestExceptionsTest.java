package pl.org.kata.test.festhamcrest.exceptions;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pl.org.kata.test.festhamcrest.BookService;
import pl.org.kata.test.festhamcrest.IBookService;

import static com.googlecode.catchexception.CatchException.catchException;
import static com.googlecode.catchexception.CatchException.caughtException;
import static org.fest.assertions.api.Assertions.assertThat;

/**
 * User: Michał Lewandowski
 * Date: 19.05.2013
 * Time: 14:28
 */
public class FestExceptionsTest {
    private IBookService sut;

    @BeforeClass
    public void setUp() {
        sut = new BookService();
    }

    /*
     * Assert exception as any other object.
     * Use catchException on run phase.
     * Use caughtException on verify phase.
     * Check if exception has message "Book ID should be positive" and is instance of IllegalArgumentException.class
     * Use catchException(sut).findBook(-1);
     */
    @Test
    public void shouldThrowException(){

    }
}
