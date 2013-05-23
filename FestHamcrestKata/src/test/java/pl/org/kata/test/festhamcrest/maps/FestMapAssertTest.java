package pl.org.kata.test.festhamcrest.maps;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pl.org.kata.test.festhamcrest.BookService;
import pl.org.kata.test.festhamcrest.IBookService;

import static org.fest.assertions.api.Assertions.assertThat;
import static org.fest.assertions.data.MapEntry.entry;

/**
 * User: Michał Lewandowski
 * Date: 19.05.2013
 * Time: 14:12
 */
public class FestMapAssertTest {
    private IBookService sut;

    @BeforeClass
    public void setUp() {
        sut = new BookService();
    }

    /*
     * Method sut.getAuthorsWithNumberOfBooks() should return map, which is not empty.
     */
    @Test
    public void shouldNotBeEmptyAndNull(){

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
        assertThat(sut.getAuthorsWithNumberOfBooks()).doesNotContain(entry("Zenek bajkopisarz",100));
    }
}
