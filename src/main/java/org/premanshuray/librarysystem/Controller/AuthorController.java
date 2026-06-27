package org.premanshuray.librarysystem.Controller;

import jakarta.validation.Valid;
import org.premanshuray.librarysystem.DTO.AuthorDTO;
import org.premanshuray.librarysystem.DTO.BookDTO;
import org.premanshuray.librarysystem.Service.AuthorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/authors")
public class AuthorController {

    private final AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping
    public ResponseEntity<List<AuthorDTO>> getAllAuthors() {
        return ResponseEntity.ok(authorService.getAllAuthors());
    }

    @PostMapping
    public ResponseEntity<AuthorDTO> createAuthor(@Valid @RequestBody AuthorDTO authorDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(authorService.createAuthor(authorDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<AuthorDTO> updateAuthor(@PathVariable Long id, @Valid @RequestBody AuthorDTO authorDTO) {
        return ResponseEntity.ok(authorService.updateAuthor(id, authorDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAuthor(@PathVariable Long id) {
        return ResponseEntity.ok(authorService.deleteAuthor(id));
    }

    @GetMapping("/{id}")
    public ResponseEntity<AuthorDTO> findAuthorById(@PathVariable Long id) {
        return ResponseEntity.ok(authorService.findAuthorById(id));
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<AuthorDTO> findAuthorByName(@PathVariable String name) {
        return ResponseEntity.ok(authorService.findAuthorByName(name));
    }

    @GetMapping("/{id}/books")
    public ResponseEntity<List<BookDTO>> findBooksByAuthorId(@PathVariable Long id) {
        return ResponseEntity.ok(authorService.findBooksByAuthorId(id));
    }

}
