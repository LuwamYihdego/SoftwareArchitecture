package books;

import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class BookRepository {

    private Map<String, Book> books = new HashMap<>();

    public Book addBook(Book book){
        return books.put(book.getIsbn(), book);
    }

    public Book updateBook(Book book){
        return books.replace(book.getIsbn(), book);
    }

    public void deleteBook(String isbn){
        books.remove(isbn);
    }

    public Book getBook(String isbn){
        return books.get(isbn);
    }

    public Books getAllBooks(){
        Books allBooks = new Books(books.values());
        return allBooks;
    }
}
