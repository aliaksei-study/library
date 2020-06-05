package com.beliakaliaksei.library.service;

import com.beliakaliaksei.library.entity.Book;
import com.beliakaliaksei.library.exception.BookNotFoundException;
import com.beliakaliaksei.library.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.List;

@Service
@Transactional
public class BookServiceImpl implements IBookService {
    private final BookRepository bookRepository;
    private final IAuthorService authorService;

    @Autowired
    public BookServiceImpl(BookRepository bookRepository, IAuthorService authorService) {
        this.bookRepository = bookRepository;
        this.authorService = authorService;
    }


    @Override
    public Page<Book> getBookPage(int page, int pageSize) {
        Pageable pageable = PageRequest.of(page, pageSize);
        return bookRepository.findAll(pageable);
    }

    @Override
    public void addNewBook(Book book) {
        bookRepository.save(book);
    }

    @Override
    public void deleteBook(Book book) {
        bookRepository.delete(book);
    }

    @Override
    public Book getById(long id) throws BookNotFoundException {
        return bookRepository.findById(id).orElseThrow(BookNotFoundException::new);
    }
}
