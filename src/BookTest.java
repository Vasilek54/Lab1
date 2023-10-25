import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BookTest {
    @Test
    void testBookProperties() {
        Book book = new Book("Sample Title", "Sample Author", "123-456-789", 2023);

        assertEquals("Sample Title", book.getTitle());
        assertEquals("Sample Author", book.getAuthor());
        assertEquals("123-456-789", book.getIsbn());
        assertEquals(2023, book.getPublicationYear());

        book.setTitle("New Title");
        book.setAuthor("New Author");
        book.setIsbn("987-654-321");
        book.setPublicationYear(2024);

        assertEquals("New Title", book.getTitle());
        assertEquals("New Author", book.getAuthor());
        assertEquals("987-654-321", book.getIsbn());
        assertEquals(2024, book.getPublicationYear());
        assertEquals("Book{title='New Title'," +
                " author='New Author'," +
                " isbn='987-654-321'," +
                " publicationYear=2024}", book.toString());
    }
}
