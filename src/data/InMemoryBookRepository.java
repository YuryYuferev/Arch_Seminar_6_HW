package data;

import domain.Book;
import java.util.ArrayList;
import java.util.List;

public class InMemoryBookRepository implements BookRepository {
    private List<Book> books;

    public InMemoryBookRepository() {
        this.books = new ArrayList<>();
    }

    @Override
    public void addBook(Book book) {
        books.add(book);
    }

    @Override
    public void removeBook(Book book) {
        books.remove(book);
    }

    @Override
    public List<Book> getAllBooks() {
        return new ArrayList<>(books);
    }
}