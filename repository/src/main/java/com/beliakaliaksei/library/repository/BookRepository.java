package com.beliakaliaksei.library.repository;

import com.beliakaliaksei.library.entity.Author;
import com.beliakaliaksei.library.entity.Book;
import com.beliakaliaksei.library.entity.Reader;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    Page<Book> findAll(Pageable pageable);
    Optional<Book> findById(long id);
    List<Book> findByAuthors(Author author);
    Optional<Book> findByReader(Reader reader);
}
