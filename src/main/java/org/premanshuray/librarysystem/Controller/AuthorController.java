package org.premanshuray.librarysystem.Controller;

import org.premanshuray.librarysystem.DTO.AuthorDTO;
import org.premanshuray.librarysystem.DTO.BookDTO;
import org.premanshuray.librarysystem.Service.AuthorService;
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
    public List<AuthorDTO> getAllAuthors(){
        return authorService.getAllAuthors();
    }

    @PostMapping
    public AuthorDTO createAuthor(@RequestBody AuthorDTO authorDTO){
        return authorService.createAuthor(authorDTO);
    }

    @PutMapping("/{id}")
    public AuthorDTO updateAuthor(@PathVariable Long id,@RequestBody AuthorDTO authorDTO){
        return authorService.updateAuthor(id,authorDTO);
    }

    @DeleteMapping("/{id}")
    public String deleteAuthor(@PathVariable Long id){
        return authorService.deleteAuthor(id);
    }

    @GetMapping("/{id}")
    public AuthorDTO findAuthorById(@PathVariable Long id){
        return authorService.findAuthorById(id);
    }

    @GetMapping("/name/{name}")
    public AuthorDTO findAuthorByName(@PathVariable String name){
        return authorService.findAuthorByName(name);
    }

    @GetMapping("/{id}/books")
    public List<BookDTO> findBooksByAuthorId(@PathVariable Long id){
        return authorService.findBooksByAuthorId(id);
    }

}
