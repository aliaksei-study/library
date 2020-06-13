package com.beliakaliaksei.library.service;

import com.beliakaliaksei.library.entity.Book;
import com.beliakaliaksei.library.entity.BookKeeper;
import com.beliakaliaksei.library.exception.BookNotFoundException;
import com.beliakaliaksei.library.exception.ReaderNotFoundException;
import com.beliakaliaksei.library.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class BookServiceImpl implements IBookService {
    private final BookRepository bookRepository;
    private final IAuthorService authorService;
    private final IReaderService readerService;
    private final IBookKeeperService bookKeeperService;

    @Autowired
    public BookServiceImpl(BookRepository bookRepository, IAuthorService authorService, IReaderService readerService,
                           IBookKeeperService bookKeeperService) {
        this.bookRepository = bookRepository;
        this.authorService = authorService;
        this.readerService = readerService;
        this.bookKeeperService = bookKeeperService;
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
}
