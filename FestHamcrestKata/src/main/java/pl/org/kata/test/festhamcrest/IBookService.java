package pl.org.kata.test.festhamcrest;

import java.util.List;
import java.util.Map;

/**
 * User: Michał Lewandowski
 * Date: 19.05.2013
 * Time: 12:01
 */
public interface IBookService {

    String findBook(Integer bookID);

    String getLibraryName();

    Integer getBooksByAuthor(String author);

    List<String> getAuthors();

    Map<String,Integer> getAuthorsWithNumberOfBooks();
}