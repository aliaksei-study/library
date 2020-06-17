package com.beliakaliaksei.library.service;

import com.beliakaliaksei.library.entity.Author;
import com.beliakaliaksei.library.exception.AuthorNotFoundException;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface IAuthorService {
    Page<Author> getPageAuthors(int page, int pageSize);
    void saveNewAuthor(Author author);
    Author getAuthorById(long id) throws AuthorNotFoundException;
    void updateAuthor(Author updatedAuthor, long id);
    void deleteAuthor(Author author);
}
