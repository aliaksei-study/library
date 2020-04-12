package com.beliakaliaksei.library.service;

import com.beliakaliaksei.library.entity.Author;
import com.beliakaliaksei.library.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
@Transactional
public class AuthorServiceImpl implements IAuthorService{
    private final AuthorRepository authorRepository;
    private List<Author> authors;

    @Autowired
    public AuthorServiceImpl(AuthorRepository authorRepository) {
        authors = new ArrayList<>();
        this.authorRepository = authorRepository;
    }

    @Override
    public void addAuthors(List<Author> authors) {
        Iterator<Author> iterator = authors.iterator();
        while(iterator.hasNext()) {
            authorRepository.save(iterator.next());
        }
    }

    @Override
    public List<Author> getAll() {
        return authorRepository.findAll();
    }

    @Override
    public void addNewAuthor(Author author) {
        authorRepository.save(author);
    }

    @Override
    public void deleteAuthor(Author author) {
        authorRepository.delete(author);
    }

    @Override
    public Author getById(long id) {
        return null;
    }

    @Override
    public List<Author> getAllFromList() {
        return authors;
    }

    @Override
    public void addNewAuthorToList(Author author) {
        authors.add(author);
    }

    @Override
    public void deleteAuthorFromList(Author author) {
        authors.remove(author);
    }

    @Override
    public Author getByIdFromList(long id) {
        return null;
    }

    @Override
    public void clearList() {
        authors.clear();
    }
}
