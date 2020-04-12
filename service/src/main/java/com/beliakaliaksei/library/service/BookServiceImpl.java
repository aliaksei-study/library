package com.beliakaliaksei.library.service;

import com.beliakaliaksei.library.entity.Book;
import com.beliakaliaksei.library.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
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
    public List<Book> getAllBook() {
        return bookRepository.findAll();
    }

    @Override
    public void addNewBook(Book book) {
        authorService.addAuthors(authorService.getAllFromList());
        book.setAuthors(authorService.getAllFromList());
        System.out.println(book);
        bookRepository.save(book);
        authorService.clearList();
        List<Book> books = getAllBook();
        System.out.println(Arrays.toString(books.toArray()));
    }

    @Override
    public void deleteBook(Book book) {
        bookRepository.delete(book);
    }

    @Override
    public Book getById(long id) {
        return null;
    }
}
