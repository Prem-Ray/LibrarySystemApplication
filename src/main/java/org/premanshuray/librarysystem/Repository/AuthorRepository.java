package org.premanshuray.librarysystem.Repository;

import jakarta.transaction.Transactional;
import org.premanshuray.librarysystem.Entity.Author;
import org.premanshuray.librarysystem.Entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {

    @Query("select a from Author a join fetch a.books")
    List<Author> findAllAuthors();

    @Modifying
    @Transactional
    @Query("insert into Author(name,email) values(:name,:email)")
    Author saveAuthor(@Param("name") String name, @Param("email") String email);

    @Modifying
    @Transactional
    @Query("update Author a set a.name=:name, a.email=:email where a.id=:id")
    Author updateAuthor(@Param("id") Long id, @Param("name")String name, @Param("email")String email);

    @Modifying
    @Transactional
    @Query("delete from Author a where a.id=:id")
    void deleteAuthor(@Param("id") Long id);

    @Query("select a from Author a where a.id=:id")
    Author findAuthorById(@Param("id") Long id);

    @Query("select a from Author a where a.name=:name")
    Author findAuthorByName(@Param("name") String name);

    @Query("select b from Book b where b.author.id=:id")
    List<Book> findBooksByAuthorId(@Param("id") Long id);
}