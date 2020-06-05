package com.beliakaliaksei.library.service;

import com.beliakaliaksei.library.entity.Book;
import com.beliakaliaksei.library.exception.BookNotFoundException;
import org.springframework.data.domain.Page;

import java.util.List;

public interface IBookService {
    Page<Book> getBookPage(int page, int pageSize);
    void addNewBook(Book book);
    void deleteBook(Book book);
    Book getById(long id) throws BookNotFoundException;
}
