package com.beliakaliaksei.library.controller;



import com.beliakaliaksei.library.entity.Book;
import com.beliakaliaksei.library.service.BookServiceImpl;
import com.beliakaliaksei.library.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {
    private final IBookService bookService;

    @Autowired
    public BookController(IBookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/all")
    public List<Book> showBooks() {
        return bookService.getAllBook();
    }
}
