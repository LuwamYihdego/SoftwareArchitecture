package books;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Collection;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @PostMapping("")
    public ResponseEntity<Book> addBook(@RequestBody Book book){
        Book saveBook = bookService.addBook(book);
        return new ResponseEntity<>(saveBook, HttpStatus.CREATED);
    }

    @PutMapping("")
    public ResponseEntity<Book> updateBook(@RequestBody Book book){
        if(book == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        bookService.updateBook(book);
        return new ResponseEntity<>(book, HttpStatus.OK);
    }

    @DeleteMapping("/{isbn}")
    public ResponseEntity<Book> deleteBook(@PathVariable String isbn){
        Book deleteBook = bookService.getBook(isbn);
        if(deleteBook == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        bookService.deleteBook(isbn);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/{isbn}")
    public ResponseEntity<Book> getBook(@PathVariable String isbn){
        Book book = bookService.getBook(isbn);
        if(book == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(book, HttpStatus.OK);
    }

    @GetMapping("")
    public ResponseEntity<Books> getAllBooks(){
        Books books = bookService.getAllBooks();
        if(books == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(books, HttpStatus.OK);
    }
}
