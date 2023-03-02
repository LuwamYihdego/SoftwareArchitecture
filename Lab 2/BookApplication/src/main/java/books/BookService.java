package books;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private JmsSender jmsSender;

    public Book addBook(Book book){

        bookRepository.addBook(book);
        jmsSender.sendMessage(book);
        return book;
    }

    public Book updateBook(Book book){

        bookRepository.updateBook(book);
        jmsSender.sendMessage(book);
        return book;
    }

    public void deleteBook(String isbn){
        Book book = bookRepository.getBook(isbn);
        bookRepository.deleteBook(isbn);
        jmsSender.sendMessage(null);
    }

    public Book getBook(String isbn){
        return bookRepository.getBook(isbn);
    }

    public Books getAllBooks(){
        return bookRepository.getAllBooks();
    }
}
