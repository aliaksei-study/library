package com.beliakaliaksei.library.controller;


import com.beliakaliaksei.library.dto.AddressDto;
import com.beliakaliaksei.library.dto.BookDto;
import com.beliakaliaksei.library.dto.PublisherDto;
import com.beliakaliaksei.library.entity.Author;
import com.beliakaliaksei.library.entity.Book;
import com.beliakaliaksei.library.exception.BookNotFoundException;
import com.beliakaliaksei.library.exception.ReaderNotFoundException;
import com.beliakaliaksei.library.service.IBookService;
import com.beliakaliaksei.library.service.IReaderService;
import com.beliakaliaksei.library.util.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/books")
public class BookController {
    private final IBookService bookService;
    private final IReaderService readerService;

    @Autowired
    public BookController(IBookService bookService, IReaderService readerService) {
        this.bookService = bookService;
        this.readerService = readerService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Page<Book> showBookPage(@RequestParam(defaultValue = "0") int page,
                                   @RequestParam(defaultValue = "5") int pageSize) {
        return bookService.getBookPage(page, pageSize);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Book getBookById(@PathVariable("id") Long bookId) throws BookNotFoundException {
        return bookService.getById(bookId);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void saveBook(@Valid @RequestBody BookDto bookDto) {
        Book book = Mapper.map(bookDto, Book.class);
        List<Author> authors = Mapper.mapAll(bookDto.getAuthorDto(), Author.class);
        book.setAuthors(authors);
        bookService.addNewBook(book);
    }

    @GetMapping("readers/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public List<String> getTitleByReader(@PathVariable("id") List<Long> readerIds) throws ReaderNotFoundException {
        List<String> titles = new ArrayList<>();
        for(Long readerId: readerIds) {
            titles.add(bookService.getBookByReader(readerService.getById(readerId)).getTitle());
        }
        return titles;
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void updateBook(@PathVariable("id") Long id, @Valid @RequestBody BookDto bookDto) {
        Book book = Mapper.map(bookDto, Book.class);
        List<Author> authors = Mapper.mapAll(bookDto.getAuthorDto(), Author.class);
        book.setAuthors(authors);
        bookService.updateBook(book, id);
    }

}
