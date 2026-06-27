package org.premanshuray.librarysystem.Controller;

import jakarta.validation.Valid;
import org.premanshuray.librarysystem.DTO.BookDTO;
import org.premanshuray.librarysystem.Service.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public ResponseEntity<List<BookDTO>> getAllBooks() {
        return ResponseEntity.ok(bookService.getAllBooks());
    }

    @PostMapping
    public ResponseEntity<BookDTO> publishBook(@Valid @RequestBody BookDTO bookDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(bookService.createBook(bookDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<BookDTO> updateBook(@PathVariable Long id, @Valid @RequestBody BookDTO bookDTO) {
        return ResponseEntity.ok(bookService.updateBook(id, bookDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteBook(@PathVariable Long id) {
        return ResponseEntity.ok(bookService.deleteBook(id));
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookDTO> findBookById(@PathVariable Long id) {
        return ResponseEntity.ok(bookService.findBookById(id));
    }

    @GetMapping("/title")
    public ResponseEntity<BookDTO> findBookByTitle(@RequestParam String title) {
        return ResponseEntity.ok(bookService.findBookByTitle(title));
    }

    @GetMapping("/after-date")
    public ResponseEntity<List<BookDTO>> findBooksAfterCertainDate(@RequestParam LocalDate date) {
        return ResponseEntity.ok(bookService.findBooksAfterCertainDate(date));
    }

}
