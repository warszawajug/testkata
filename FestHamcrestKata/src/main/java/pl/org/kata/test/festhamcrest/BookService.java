package pl.org.kata.test.festhamcrest;

import java.util.*;

/**
 * User: Michał Lewandowski
 * Date: 19.05.2013
 * Time: 12:04
 */
public class BookService implements IBookService {

    @Override
    public String findBook(Integer bookID) {
        if (bookID == null) {
            return "";
        }else if(bookID < 0){
           throw new IllegalArgumentException("Book ID should be positive");
        }
        else if (bookID == 1) {
            return "Romeo and Juliet";
        } else {
            return "";
        }
    }

    @Override
    public String getLibraryName() {
        return "Ultimate JUG JVM Library";
    }

    @Override
    public Integer getBooksByAuthor(String author) {
        if (author == null) {
            return 0;
        } else if (author.equals("Shakespeare")) {
            return 431;
        } else {
            return 0;
        }
    }

    @Override
    public List<String> getAuthors() {
        return Collections.unmodifiableList(Arrays.asList("Shakespeare", "Tolkien"));
    }

    @Override
    public Map<String, Integer> getAuthorsWithNumberOfBooks() {
        Map<String, Integer> authorsWithBooks = new HashMap<String, Integer>();
        authorsWithBooks.put("Shakespeare", 431);
        authorsWithBooks.put("Tolkien", 0);
        return Collections.unmodifiableMap(authorsWithBooks);
    }
}
