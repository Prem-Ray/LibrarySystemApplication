package org.premanshuray.librarysystem.Service;


import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.premanshuray.librarysystem.DTO.AuthorDTO;
import org.premanshuray.librarysystem.DTO.BookDTO;
import org.premanshuray.librarysystem.Entity.Author;
import org.premanshuray.librarysystem.Entity.Book;
import org.premanshuray.librarysystem.Repository.AuthorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthorService {

    private final AuthorRepository authorRepository;
    private final ModelMapper modelMapper;

    public List<AuthorDTO> getAllAuthors() {
        return authorRepository.findAllAuthors()
                .stream()
                .map(author -> modelMapper.map(author, AuthorDTO.class))
                .toList();
    }



    private boolean isIdExist(Long id) {
        return authorRepository.existsById(id);
    }

    public AuthorDTO createAuthor(AuthorDTO authorDTO) {
        String name=authorDTO.getName();
        String email=authorDTO.getEmail();
        Author createdAuthor =authorRepository.saveAuthor(name,email);
        return modelMapper.map(createdAuthor, AuthorDTO.class);
    }

    public AuthorDTO updateAuthor(Long id,AuthorDTO authorDTO) {
        if(!isIdExist(id)) throw new EntityNotFoundException("Author with id " + id + " not found");
        String name = authorDTO.getName();
        String email = authorDTO.getEmail();
        Author updatedAuthor = authorRepository.updateAuthor(id,name,email);
        return modelMapper.map(updatedAuthor,AuthorDTO.class);
    }

    public String deleteAuthor(Long id) {
        if(!isIdExist(id)) throw new EntityNotFoundException("Author with id " + id + " not found");
        authorRepository.deleteAuthor(id);
        return "Author with id " + id + " deleted successfully";
    }

    public AuthorDTO findAuthorById(Long id) {
        if(!isIdExist(id)) throw new EntityNotFoundException("Author with id " + id + " not found");
        Author author = authorRepository.findAuthorById(id);
        return modelMapper.map(author,AuthorDTO.class);
    }

    public AuthorDTO findAuthorByName(String name) {
        Author author = authorRepository.findAuthorByName(name);
        return modelMapper.map(author,AuthorDTO.class);
    }

    public List<BookDTO> findBooksByAuthorId(Long id) {
        if(!isIdExist(id)) throw new EntityNotFoundException("Author with id " + id + " not found");
        List<Book> books = authorRepository.findBooksByAuthorId(id);
        return books.stream()
                .map(book -> modelMapper.map(book, BookDTO.class))
                .toList();
    }
}
