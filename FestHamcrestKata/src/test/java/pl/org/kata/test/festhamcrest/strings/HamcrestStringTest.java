package pl.org.kata.test.festhamcrest.strings;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pl.org.kata.test.festhamcrest.BookService;
import pl.org.kata.test.festhamcrest.IBookService;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

/**
 * User: Michał Lewandowski
 * Date: 19.05.2013
 * Time: 13:33
 */
public class HamcrestStringTest {
    private IBookService sut;

    @BeforeClass
    public void setUp() {
        sut = new BookService();
    }

    /*
     * Method sut.getLibraryName() should not be null or empty .
     */
    @Test
    public void shouldNotBeNullOrEmpty() {
        assertThat(sut.getLibraryName(), both(not("")).and(notNullValue()));
    }

    /*
     * Method sut.getLibraryName() should equal ignoring case to "ultimate jug jvm library" .
     */
    @Test
    public void shouldBeEqualIgnoringCase() {

    }

    /*
     * Method sut.getLibraryName() should equal to "Ultimate JUG JVM Library" .
     */
    @Test
    public void shouldBeEqual() {

    }

    /*
     * Method result sut.getLibraryName() should contains "JVM" .
     */
    @Test
    public void shouldContainsJVM() {

    }

    /*
     * Method result sut.getLibraryName() should not contains "C#" .
     */
    @Test
    public void shouldNotContainCSharp() {

    }

    /*
     * Method result sut.getLibraryName() should ends with "Library" .
     */
    @Test
    public void shouldEndsWithLibrary() {

    }

    /*
     * Method result sut.getLibraryName() should has size 24 .
     */
    @Test
    public void shouldHaveSize24() {

    }

    /*
     * Method result sut.findBook(2) should return null or empty .
     */
    @Test()
    public void titleShouldBeNullOrEmpty() {

    }

}
