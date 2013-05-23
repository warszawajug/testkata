package pl.org.kata.test.festhamcrest.maps;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pl.org.kata.test.festhamcrest.BookService;
import pl.org.kata.test.festhamcrest.IBookService;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.Matchers.notNullValue;


/**
 * User: Michał Lewandowski
 * Date: 19.05.2013
 * Time: 14:12
 */
public class HamcrestMapAssertTest {
    private IBookService sut;

    @BeforeClass
    public void setUp() {
        sut = new BookService();
    }

    /*
     * Method sut.getAuthorsWithNumberOfBooks() should return map, which is not empty.
     * In version 1.3 checking if map is not empty is not supported.
     * See commit: https://github.com/hamcrest/JavaHamcrest/commit/749ef4be528e489139aec9d5ad40188078dab389
     */
    @Test
    public void shouldNotBeEmptyAndNull(){
        assertThat(sut.getAuthorsWithNumberOfBooks(), notNullValue());
        assertThat(sut.getAuthorsWithNumberOfBooks().size(), is(greaterThan(0)));
    }

    /*
     * Method sut.getAuthorsWithNumberOfBooks() should return map, which contains key "Shakespeare".
     */
    @Test
    public void shouldContainKeyShakespeare(){
    }

    /*
     * Method sut.getAuthorsWithNumberOfBooks() should return map, which contains value "431".
     */
    @Test
    public void shouldContainValue431(){

    }

    /*
     * Method sut.getAuthorsWithNumberOfBooks() should return map, which has size "2".
     */
    @Test
    public void shouldHaveSizeTwo(){

    }

    /*
     * Method sut.getAuthorsWithNumberOfBooks() should return map, which has entry: "Shakespeare" -> 431.
     */
    @Test
    public void shouldContainEntryShakespeare(){

    }


    /*
     * Method sut.getAuthorsWithNumberOfBooks() should return map, without entry: "Zenek bajkopisarz" -> 100.
     */
    @Test
    public void shouldNotContainEntryZenek(){

    }
}
