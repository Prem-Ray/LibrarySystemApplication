package org.premanshuray.librarysystem.Controller;

import org.premanshuray.librarysystem.DTO.BookDTO;
import org.premanshuray.librarysystem.Service.BookService;
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
    public List<BookDTO>getAllBooks(){
        return bookService.getAllBooks();
    }

    @PostMapping
    public BookDTO publishBook(@RequestBody BookDTO bookDTO){
        return bookService.createBook(bookDTO);
    }

    @PutMapping("/{id}")
    public BookDTO updateBook(@PathVariable Long id, @RequestBody BookDTO bookDTO) {
        return bookService.updateBook(id, bookDTO);
    }

    @DeleteMapping("/{id}")
    public String deleteBook(@PathVariable Long id) {
        return bookService.deleteBook(id);
    }

    @GetMapping("/{id}")
    public BookDTO findBookById(@PathVariable Long id){
        return bookService.findBookById(id);
    }

    @GetMapping("/title")
    public BookDTO findBookByTitle(@RequestParam String title){
        return bookService.findBookByTitle(title);
    }

    @GetMapping("/after-date")
    public List<BookDTO>findBooksAfterCertainDate(@RequestParam LocalDate date){
        return bookService.findBooksAfterCertainDate(date);
    }



}
