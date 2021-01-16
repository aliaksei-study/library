package com.beliakaliaksei.library.service;

import com.beliakaliaksei.library.entity.Author;
import com.beliakaliaksei.library.entity.Book;
import com.beliakaliaksei.library.entity.BookKeeper;
import com.beliakaliaksei.library.entity.Reader;
import com.beliakaliaksei.library.exception.BookNotFoundException;
import com.beliakaliaksei.library.exception.ReaderNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;

public interface IBookService {
    Page<Book> getBookPage(int page, int pageSize, String sort);
    Page<Book> getFilteredBookPage(int page, int pageSize, Specification<Book> bookSpecification);
    void addNewBook(Book book);
    void deleteBook(Book book) throws BookNotFoundException;
    Book getById(long id) throws BookNotFoundException;
    void giveOutTheBook(BookKeeper bookKeeper, Long bookId, Long readerId) throws ReaderNotFoundException, BookNotFoundException;
    void returnTheBook(Long bookId) throws BookNotFoundException;
    List<Book> getBooksWhichWereWrittenByDeletedAuthor(Author author);
    void setDeletedAuthorToNull(List<Book> books, Author author);
    Book getBookByReader(Reader reader);
    void updateBook(Book book, Long id);
}
