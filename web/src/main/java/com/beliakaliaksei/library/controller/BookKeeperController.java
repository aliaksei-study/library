package com.beliakaliaksei.library.controller;

import com.beliakaliaksei.library.dto.BookKeeperDto;
import com.beliakaliaksei.library.entity.BookKeeper;
import com.beliakaliaksei.library.exception.BookNotFoundException;
import com.beliakaliaksei.library.exception.ReaderNotFoundException;
import com.beliakaliaksei.library.service.IBookService;
import com.beliakaliaksei.library.util.Mapper;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/book-keeper")
public class BookKeeperController {
    private final IBookService bookService;

    public BookKeeperController(IBookService bookService){
        this.bookService = bookService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void saveBookKeeper(@Valid @RequestBody BookKeeperDto bookKeeperDto) throws ReaderNotFoundException,
            BookNotFoundException {
        bookService.giveOutTheBook(Mapper.map(bookKeeperDto, BookKeeper.class), bookKeeperDto.getBookId(),
                bookKeeperDto.getReaderId());
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void deleteBookKeeper(@PathVariable("id") Long bookId) throws BookNotFoundException {
        bookService.returnTheBook(bookId);
    }
}
