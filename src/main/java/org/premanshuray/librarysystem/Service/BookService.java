package org.premanshuray.librarysystem.Service;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.premanshuray.librarysystem.DTO.BookDTO;
import org.premanshuray.librarysystem.Entity.Book;
import org.premanshuray.librarysystem.Repository.BookRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;
    private final ModelMapper modelMapper;

    public List<BookDTO> getAllBooks() {

        return bookRepository.findAllBooks()
                .stream()
                .map(book -> modelMapper.map(book, BookDTO.class))
                .toList();
    }

    public BookDTO createBook(BookDTO bookDTO) {
        String name=bookDTO.getName();
        LocalDate publishedDate = bookDTO.getPublishedDate();
        Long authorId = bookDTO.getAuthorId();
        Book publishedBook = bookRepository.createBook(name,publishedDate,authorId);
        return modelMapper.map(publishedBook,BookDTO.class);
    }

    public BookDTO updateBook(Long id, BookDTO bookDTO) {
        String name=bookDTO.getName();
        LocalDate publishedDate = bookDTO.getPublishedDate();
        Long authorId = bookDTO.getAuthorId();
        Book updatedBook = bookRepository.updateBook(id,name,publishedDate,authorId);
        return modelMapper.map(updatedBook,BookDTO.class);
    }

    public String deleteBook(Long id) {
        if(!isIdExist(id)){
            throw new EntityNotFoundException("Book with id " + id + " not found");
        }
        bookRepository.deleteByID(id);
        return "Book with " + id + " deleted successfully";
    }


    public BookDTO findBookById(Long id) {
        Book bookEntity = bookRepository.findByID(id);
        return modelMapper.map(bookEntity,BookDTO.class);
    }

    public BookDTO findBookByTitle(String title) {
        Book book = bookRepository.findBookByTitle(title);
        return modelMapper.map(book,BookDTO.class);
    }

    public List<BookDTO> findBooksAfterCertainDate(LocalDate date) {
        List<Book>books = bookRepository.findByPublishedDateAfter(date);
        return books.stream()
                .map(book -> modelMapper.map(book, BookDTO.class))
                .toList();
    }

    private boolean isIdExist(Long id) {
        return bookRepository.existsById(id);
    }

}
