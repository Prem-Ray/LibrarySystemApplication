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
        if (bookDTO == null) {
            throw new IllegalArgumentException("BookDTO cannot be null");
        }
        if (bookDTO.getName() == null || bookDTO.getName().isEmpty()) {
            throw new IllegalArgumentException("Book name cannot be null or empty");
        }
        if (bookDTO.getAuthorId() == null) {
            throw new IllegalArgumentException("Author ID cannot be null");
        }
        String name = bookDTO.getName();
        LocalDate publishedDate = bookDTO.getPublishedDate();
        Long authorId = bookDTO.getAuthorId();
        bookRepository.createBook(name, publishedDate, authorId);
        List<Book> books = bookRepository.findAllBooks();
        Book publishedBook = books.stream()
                .filter(b -> b.getName().equals(name))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Failed to retrieve created book"));
        return modelMapper.map(publishedBook, BookDTO.class);
    }

    public BookDTO updateBook(Long id, BookDTO bookDTO) {
        if (!isIdExist(id)) {
            throw new EntityNotFoundException("Book with id " + id + " not found");
        }
        if (bookDTO == null) {
            throw new IllegalArgumentException("BookDTO cannot be null");
        }
        String name = bookDTO.getName();
        LocalDate publishedDate = bookDTO.getPublishedDate();
        Long authorId = bookDTO.getAuthorId();
        bookRepository.updateBook(id, name, publishedDate, authorId);
        Book updatedBook = bookRepository.findByID(id);
        if (updatedBook == null) {
            throw new RuntimeException("Failed to retrieve updated book");
        }
        return modelMapper.map(updatedBook, BookDTO.class);
    }

    public String deleteBook(Long id) {
        if (!isIdExist(id)) {
            throw new EntityNotFoundException("Book with id " + id + " not found");
        }
        bookRepository.deleteByID(id);
        return "Book with " + id + " deleted successfully";
    }

    public BookDTO findBookById(Long id) {
        if (!isIdExist(id)) {
            throw new EntityNotFoundException("Book with id " + id + " not found");
        }
        Book bookEntity = bookRepository.findByID(id);
        if (bookEntity == null) {
            throw new EntityNotFoundException("Book with id " + id + " not found");
        }
        return modelMapper.map(bookEntity, BookDTO.class);
    }

    public BookDTO findBookByTitle(String title) {
        if (title == null || title.isEmpty()) {
            throw new IllegalArgumentException("Title cannot be null or empty");
        }
        Book book = bookRepository.findBookByTitle(title);
        if (book == null) {
            throw new EntityNotFoundException("Book with title '" + title + "' not found");
        }
        return modelMapper.map(book, BookDTO.class);
    }

    public List<BookDTO> findBooksAfterCertainDate(LocalDate date) {
        if (date == null) {
            throw new IllegalArgumentException("Date cannot be null");
        }
        List<Book> books = bookRepository.findByPublishedDateAfter(date);
        return books.stream()
                .map(book -> modelMapper.map(book, BookDTO.class))
                .toList();
    }

    private boolean isIdExist(Long id) {
        return bookRepository.existsById(id);
    }

}
