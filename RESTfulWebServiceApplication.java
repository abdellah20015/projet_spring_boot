import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class RESTfulWebServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(RESTfulWebServiceApplication.class, args);
    }
}

@RestController
@RequestMapping("/api")
class BookController {

    private List<Book> books = new ArrayList<>();

    @GetMapping("/books")
    public List<Book> getAllBooks() {
        return books;
    }

    @PostMapping("/books")
    public Book addBook(@RequestBody Book book) {
        books.add(book);
        return book;
    }

    @GetMapping("/books/{id}")
    public Book getBookById(@PathVariable int id) {
        return books.get(id);
    }

    @PutMapping("/books/{id}")
    public Book updateBook(@PathVariable int id, @RequestBody Book book) {
        books.set(id, book);
        return book;
    }

    @DeleteMapping("/books/{id}")
    public void deleteBook(@PathVariable int id) {
        books.remove(id);
    }
}

class Book {
    private int id;
    private String title;
    private String author;

    // Getters and setters
}