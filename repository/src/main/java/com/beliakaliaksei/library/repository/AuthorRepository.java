package com.beliakaliaksei.library.repository;

import com.beliakaliaksei.library.entity.Author;
import com.beliakaliaksei.library.entity.Reader;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {
    Page<Author> findAll(Pageable pageable);
}
