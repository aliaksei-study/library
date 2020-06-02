package com.beliakaliaksei.library.controller;


import com.beliakaliaksei.library.dto.AddressDto;
import com.beliakaliaksei.library.dto.BookDto;
import com.beliakaliaksei.library.dto.PublisherDto;
import com.beliakaliaksei.library.entity.Author;
import com.beliakaliaksei.library.entity.Book;
import com.beliakaliaksei.library.service.IBookService;
import com.beliakaliaksei.library.util.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/books")
public class BookController {
    private final IBookService bookService;

    @Autowired
    public BookController(IBookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Page<Book> showBookPage(@RequestParam(defaultValue = "0") int page,
                                   @RequestParam(defaultValue = "5") int pageSize) {
        return bookService.getBookPage(page, pageSize);
    }

    @PostMapping
    public void saveBook(@Valid @RequestBody BookDto bookDto) {
//        bookService.addNewBook(Mapper.map(bookDto, Book.class));
        Book book = Mapper.map(bookDto, Book.class);
        List<Author> authors = Mapper.mapAll(bookDto.getAuthorDto(), Author.class);
        book.setAuthors(authors);
        bookService.addNewBook(book);
    }
}
