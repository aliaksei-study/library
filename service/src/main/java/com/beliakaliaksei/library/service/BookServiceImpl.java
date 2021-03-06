package com.beliakaliaksei.library.service;

import com.beliakaliaksei.library.entity.Author;
import com.beliakaliaksei.library.entity.Book;
import com.beliakaliaksei.library.entity.BookKeeper;
import com.beliakaliaksei.library.entity.Reader;
import com.beliakaliaksei.library.exception.BookNotFoundException;
import com.beliakaliaksei.library.exception.ReaderNotFoundException;
import com.beliakaliaksei.library.filter.SearchCriteria;
import com.beliakaliaksei.library.filter.bookfilter.BookSpecification;
import com.beliakaliaksei.library.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collections;
import java.util.List;

@Service
@Transactional
public class BookServiceImpl implements IBookService {
    private final BookRepository bookRepository;
    private final IReaderService readerService;
    private final IBookKeeperService bookKeeperService;

    @Autowired
    public BookServiceImpl(BookRepository bookRepository, IAuthorService authorService, IReaderService readerService,
                           IBookKeeperService bookKeeperService) {
        this.bookRepository = bookRepository;
        this.readerService = readerService;
        this.bookKeeperService = bookKeeperService;
    }


    @Override
    public Page<Book> getBookPage(int page, int pageSize, String sort) {
        Pageable pageable;
        if(sort == null) {
            pageable = PageRequest.of(page, pageSize);
        } else {
            pageable = PageRequest.of(page, pageSize, Sort.by(sort));
        }

        return bookRepository.findAll(pageable);
    }

    @Override
    public Page<Book> getFilteredBookPage(int page, int pageSize, Specification<Book> bookSpecification) {
        Pageable pageable = PageRequest.of(page, pageSize);
        return bookRepository.findAll(bookSpecification, pageable);
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

    @Override
    public void giveOutTheBook(BookKeeper bookKeeper, Long bookId, Long readerId) throws ReaderNotFoundException, BookNotFoundException {
        Book book = getById(bookId);
        book.setReader(readerService.getById(readerId));
        book.setBookKeeper(bookKeeper);
        bookRepository.save(book);
    }

    @Override
    public void returnTheBook(Long bookId) throws BookNotFoundException {
        Book book = getById(bookId);
        BookKeeper bookKeeper = book.getBookKeeper();
        book.setReader(null);
        book.setBookKeeper(null);
        bookKeeperService.removeBookKeeper(bookKeeper);
        bookRepository.save(book);
    }

    @Override
    public List<Book> getBooksWhichWereWrittenByDeletedAuthor(Author author) {
        return bookRepository.findByAuthors(author);
    }

    @Override
    public void setDeletedAuthorToNull(List<Book> books, Author author) {
        for(Book book: books) {
            book.getAuthors().removeIf((bookAuthor) -> bookAuthor.equals(author));
            bookRepository.save(book);
        }
    }

    @Override
    public Book getBookByReader(Reader reader){
        return bookRepository.findByReader(reader).orElseGet(Book::new);
    }

    @Override
    public void updateBook(Book book, Long id) {
        book.setId(id);
        bookRepository.save(book);
    }
}
