import java.util.List;
import java.util.Scanner;

public class Main {
    private static final Library library = new Library();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("Menu:");
            System.out.println("1. Add a book");
            System.out.println("2. Show all books");
            System.out.println("3. Search for a book by title");
            System.out.println("4. Remove a book by ISBN");
            System.out.println("5. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    addBook();
                    break;
                case 2:
                    displayAllBooks();
                    break;
                case 3:
                    searchByTitle();
                    break;
                case 4:
                    removeByIsbn();
                    break;
                case 5:
                    System.out.println("Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
                    break;
            }
        }
    }

    private static void addBook() {
        System.out.println("Enter the title of the book:");
        String title = scanner.nextLine();

        System.out.println("Enter the author of the book:");
        String author = scanner.nextLine();

        System.out.println("Enter the ISBN of the book:");
        String isbn = scanner.nextLine();

        System.out.println("Enter the publication year of the book:");
        int year = scanner.nextInt();

        Book book = new Book(title, author, isbn, year);
        library.addBook(book);
        System.out.println("Book added successfully!");
    }

    private static void displayAllBooks() {
        List<Book> books = library.getAllBooks();
        if (books.isEmpty()) {
            System.out.println("Library is empty.");
        } else {
            books.forEach(System.out::println);
        }
    }

    private static void searchByTitle() {
        System.out.println("Enter the title of the book to search:");
        String title = scanner.nextLine();

        List<Book> foundBooks = library.findBooksByTitle(title);
        if (foundBooks.isEmpty()) {
            System.out.println("No books found with that title.");
        } else {
            foundBooks.forEach(System.out::println);
        }
    }

    private static void removeByIsbn() {
        System.out.println("Enter the ISBN of the book to remove:");
        String isbn = scanner.nextLine();

        if (library.removeBookByIsbn(isbn)) {
            System.out.println("Book removed successfully!");
        } else {
            System.out.println("No book found with that ISBN.");
        }
    }
}
