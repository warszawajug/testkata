package pl.org.kata.test.festhamcrest.custom;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pl.org.kata.test.festhamcrest.Book;
import pl.org.kata.test.festhamcrest.BookService;
import pl.org.kata.test.festhamcrest.IBookService;

import static org.fest.assertions.api.Assertions.assertThat;
import static pl.org.kata.test.festhamcrest.custom.CustomFestCondition.valid;

/**
 * User: Michał Lewandowski
 * Date: 19.05.2013
 * Time: 14:50
 */
public class CustomFestTest {
    private IBookService sut;

    @BeforeClass
    public void setUp() {
        sut = new BookService();
    }

    @DataProvider(name = "correct")
    public Object[][] correctBooks() {
        return new Object[][] { { new Book("Shakespeare", "Romeo and Juliet", 231) }, { new Book("Shakespeare", "Hamlet", 1)} };
    }

    @DataProvider(name = "wrong")
    public Object[][] wrongBooks() {
        return new Object[][] { { new Book("", "Romeo and Juliet", 231) }, { new Book("Shakespeare", null, 1)},{ new Book("Shakespeare", "Hamlet", 0)} };
    }

    @Test(dataProvider = "correct")
    public void shouldBooksCorrect(Book book) {
         //TODO Write assert here
    }

    @Test(dataProvider = "wrong")
    public void shouldBooksWrong(Book book) {
        //TODO Write assert here
    }






}
