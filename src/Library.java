import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Library {
    // Колекція для зберігання книг
    private List<Book> books;

    // Конструктор
    public Library() {
        this.books = new ArrayList<>();
    }

    // Додавання нової книги в бібліотеку
    public void addBook(Book book) {
        books.add(book);
    }

    // Показувати всі книги в бібліотеці
    public List<Book> getAllBooks() {
        return new ArrayList<>(books);
    }

    // Шукати книгу за її назвою
    public List<Book> findBooksByTitle(String title) {
        return books.stream()
                .filter(book -> book.getTitle().equalsIgnoreCase(title))
                .collect(Collectors.toList());
    }

    // Видаляти книгу з бібліотеки за її номером ISBN
    public boolean removeBookByIsbn(String isbn) {
        return books.removeIf(book -> book.getIsbn().equals(isbn));
    }
}
