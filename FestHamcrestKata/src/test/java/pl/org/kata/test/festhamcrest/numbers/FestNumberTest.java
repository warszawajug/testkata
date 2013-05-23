package pl.org.kata.test.festhamcrest.numbers;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pl.org.kata.test.festhamcrest.BookService;
import pl.org.kata.test.festhamcrest.IBookService;

import static org.fest.assertions.api.Assertions.assertThat;

/**
 * User: Michał Lewandowski
 * Date: 19.05.2013
 * Time: 12:35
 */
public class FestNumberTest {
    private IBookService sut;

    @BeforeClass
    public void setUp() {
        sut = new BookService();
    }

    /*
     * Method getBooksByAuthor("Shakespeare") should be positive .
     */
    @Test
    public void shouldHavePositiveAmountOfBooks() {
        assertThat(sut.getBooksByAuthor("Shakespeare")).isNotNull().isPositive();
    }

    /*
     * Method getBooksByAuthor("Shakespeare") should not be 111 .
     */
    @Test
    public void shouldNotBe111() {

    }

    /*
     * Method getBooksByAuthor("Shakespeare") should return at least 100 books or equal 100 .
     */
    @Test
    public void shouldHaveAtLeast100Books() {

    }

    /*
     * Method getBooksByAuthor("Shakespeare") should not return more than 1000 books (excluding 1000) .
     */
    @Test
    public void shouldHaveNoMoreThan1000Books() {

    }

    /*
    * Method getBooksByAuthor("Shakespeare") should return 431 books.
    */
    @Test
    public void shouldHave431Books() {

    }

    /*
     * Method getBooksByAuthor("Tolkien") should return 0 book.
     */
    @Test
    public void shouldBeZeroForTolkienAuthor() {

    }






}
