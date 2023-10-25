public class Main {
    public static void main(String[] args) {
        Book book = new Book("Lord of the rings", "Tolkien", "3213123", 1954);
        System.out.println(book.getAuthor());
        System.out.println(book.getIsbn());
        System.out.println(book.getPublicationYear());
        System.out.println(book.getTitle());
        book.setTitle("Lord of the rings 1");
        System.out.println(book);

        Library library = new Library();
        library.addBook(book);
        System.out.println(library.getAllBooks());
        System.out.println(library.findBooksByTitle(book.getTitle()));
        library.removeBookByIsbn(book.getIsbn());
        System.out.println(library.getAllBooks());
    }
}