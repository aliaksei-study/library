package com.beliakaliaksei.library.service;

import com.beliakaliaksei.library.entity.Author;

import java.util.List;
import java.util.Set;

public interface IAuthorService {
    List<Author> getAll();
    void addNewAuthor(Author author);
    void deleteAuthor(Author author);
    Author getById(long id);
    List<Author> getAllFromList();
    void addNewAuthorToList(Author author);
    void deleteAuthorFromList(Author author);
    Author getByIdFromList(long id);
    void clearList();
}
