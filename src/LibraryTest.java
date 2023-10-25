import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class LibraryTest {
    private Library library;

    @BeforeEach
    void setUp() {
        library = new Library();
    }

    @Test
    void testAddAndRetrieveBook() {
        Book book = new Book("Sample Title", "Sample Author", "123-456-789", 2023);
        library.addBook(book);
        List<Book> books = library.getAllBooks();

        assertFalse(books.isEmpty());
        assertEquals(1, books.size());
        assertEquals(book, books.get(0));
    }

    @Test
    void testFindBookByTitle() {
        Book book1 = new Book("Sample Title", "Sample Author", "123-456-789", 2023);
        Book book2 = new Book("Another Title", "Another Author", "987-654-321", 2024);

        library.addBook(book1);
        library.addBook(book2);

        List<Book> foundBooks = library.findBooksByTitle("Sample Title");

        assertEquals(1, foundBooks.size());
        assertEquals(book1, foundBooks.get(0));
    }

    @Test
    void testRemoveBookByIsbn() {
        Book book1 = new Book("Sample Title", "Sample Author", "123-456-789", 2023);
        Book book2 = new Book("Another Title", "Another Author", "987-654-321", 2024);

        library.addBook(book1);
        library.addBook(book2);

        assertTrue(library.removeBookByIsbn("123-456-789"));
        List<Book> books = library.getAllBooks();

        assertEquals(1, books.size());
        assertEquals(book2, books.get(0));
    }

    @Test
    void testRemoveNonExistentIsbn() {
        assertFalse(library.removeBookByIsbn("non-existent-isbn"));
    }
}
