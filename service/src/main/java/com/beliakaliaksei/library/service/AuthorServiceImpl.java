package com.beliakaliaksei.library.service;

import com.beliakaliaksei.library.entity.Author;
import com.beliakaliaksei.library.exception.AuthorNotFoundException;
import com.beliakaliaksei.library.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
@Transactional
public class AuthorServiceImpl implements IAuthorService {
    private final AuthorRepository authorRepository;

    @Autowired
    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public Page<Author> getPageAuthors(int page, int pageSize) {
        Pageable pageable = PageRequest.of(page, pageSize);
        return authorRepository.findAll(pageable);
    }

    @Override
    public void saveNewAuthor(Author author) {
        authorRepository.save(author);
    }

    @Override
    public Author getAuthorById(long id) throws AuthorNotFoundException {
        return authorRepository.findById(id).orElseThrow(() -> new AuthorNotFoundException("Author does not exist"));
    }

    @Override
    public void updateAuthor(Author updatedAuthor, long id) {
        updatedAuthor.setId(id);
        authorRepository.save(updatedAuthor);
    }

    @Override
    public void deleteAuthor(Author author) {
        authorRepository.delete(author);
    }

    @Override
    public Author findByNote(String note) {
        return authorRepository.findByNote(note);
    }
}
