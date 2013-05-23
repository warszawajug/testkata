package pl.org.kata.test.festhamcrest.list;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pl.org.kata.test.festhamcrest.BookService;
import pl.org.kata.test.festhamcrest.IBookService;

import static org.fest.assertions.api.Assertions.assertThat;
import static org.fest.assertions.api.Assertions.atIndex;

/**
 * User: Michał Lewandowski
 * Date: 19.05.2013
 * Time: 14:05
 */
public class FestListAssertTest {
    private IBookService sut;

    @BeforeClass
    public void setUp() {
        sut = new BookService();
    }

    /*
     * Method sut.getAuthors() should return not null and not empty list .
     */
    @Test
    public void shouldNotBeNullAndEmpty(){
        assertThat(sut.getAuthors()).isNotNull().isNotEmpty();
    }

    /*
     * Method sut.getAuthors() should return list with two elements .
     */
    @Test
    public void shouldHaveTwoElements(){

    }

    /*
     * Method sut.getAuthors() should return list, where first element is "Shakespeare".
     */
    @Test
    public void shouldContainShakespeareElementAtIndexZero(){

    }

    /*
     * Method sut.getAuthors() should return list, where there is such element as "Zenek bajkopisarz".
     */
    @Test
    public void shouldNotContainElementZenek(){

    }
}
