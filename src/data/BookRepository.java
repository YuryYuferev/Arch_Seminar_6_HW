package data;

import domain.Book;
import java.util.List;

public interface BookRepository {
    void addBook(Book book);
    void removeBook(Book book);
    List<Book> getAllBooks();
}