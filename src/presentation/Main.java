package presentation;

import business.BookManager;
import data.BookRepository;
import data.InMemoryBookRepository;
import domain.Book;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static BookManager bookManager;

    public static void main(String[] args) {
        BookRepository bookRepository = new InMemoryBookRepository();
        bookManager = new BookManager(bookRepository);

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Add book");
            System.out.println("2. Remove book");
            System.out.println("3. Show all books");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addBook(scanner);
                    break;
                case 2:
                    removeBook(scanner);
                    break;
                case 3:
                    showAllBooks();
                    break;
                case 4:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        }
    }

    private static void addBook(Scanner scanner) {
        System.out.print("Enter book title: ");
        String title = scanner.nextLine();

        System.out.print("Enter book author: ");
        String author = scanner.nextLine();

        System.out.print("Enter book price: ");
        double price = scanner.nextDouble();
        scanner.nextLine();

        Book book = new Book(title, author, price);
        bookManager.addBook(book);

        System.out.println("Book added successfully");
    }

    private static void removeBook(Scanner scanner) {
        System.out.print("Enter book title: ");
        String title = scanner.nextLine();

        System.out.print("Enter book author: ");
        String author = scanner.nextLine();

        System.out.print("Enter book price: ");
        double price = scanner.nextDouble();
        scanner.nextLine();

        Book book = new Book(title, author, price);
        bookManager.removeBook(book);

        System.out.println("Book removed successfully");
    }

    private static void showAllBooks() {
        List<Book> books = bookManager.getAllBooks();

        if (books.isEmpty()) {
            System.out.println("No books found");
        } else {
            for (Book book : books) {
                System.out.println(book.getTitle() + " by " + book.getAuthor() + " - $" + book.getPrice());
            }
        }
    }
}