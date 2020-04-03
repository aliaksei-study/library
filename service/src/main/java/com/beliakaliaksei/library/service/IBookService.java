package com.beliakaliaksei.library.service;

import com.beliakaliaksei.library.entity.Book;

import java.util.List;

public interface IBookService {
    List<Book> getAllBook();
    void addNewBook(Book book);
    void deleteBook(Book book);
    Book getById(long id);
}
