package org.premanshuray.librarysystem.Repository;

import jakarta.transaction.Transactional;
import org.premanshuray.librarysystem.Entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    @Query("select b from Book b join fetch b.author")
    List<Book> findAllBooks();

    @Query("select b from Book b where b.name=:title")
    Book findBookByTitle(@Param("title") String title);

    @Query("select b from Book b where b.id=:id")
    Book findByID(@Param("id") Long id);

    @Modifying
    @Transactional
    @Query("delete from Book b where b.id=:id")
    void deleteByID(@Param("id") Long id);

    @Query("select b from Book b where b.publishedDate > :date")
    List<Book> findByPublishedDateAfter(@Param("date") LocalDate date);

    @Modifying
    @Transactional
    @Query("insert into Book(name, publishedDate, author) values(:name, :publishedDate, (select a from Author a where a.id = :authorId))")
    Book createBook(String name, LocalDate publishedDate, Long authorId);

    @Modifying
    @Transactional
    @Query("update Book b set b.name=:name, b.publishedDate=:publishedDate, b.author=(select a from Author a where a.id = :authorId) where b.id=:id")
    Book updateBook(Long id, String name, LocalDate publishedDate, Long authorId);
}