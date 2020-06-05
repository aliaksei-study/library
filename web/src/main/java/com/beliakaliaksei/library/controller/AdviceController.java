package com.beliakaliaksei.library.controller;

import com.beliakaliaksei.library.exception.*;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class AdviceController {

    @ResponseBody
    @ExceptionHandler({SuchEmailAlreadyExistsException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    String suchEmailAlreadyExistsHandler(SuchEmailAlreadyExistsException ex) {
        return ex.getMessage();
    }

    @ResponseBody
    @ExceptionHandler({ReaderNotFoundException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    String readerNotFoundHandler(ReaderNotFoundException ex) {
        return ex.getMessage();
    }

    @ResponseBody
    @ExceptionHandler({UserNotFoundException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    String userNotFoundHandler(UserNotFoundException ex) {
        return ex.getMessage();
    }

    @ResponseBody
    @ExceptionHandler({AuthorNotFoundException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    String authorNotFoundHandler(AuthorNotFoundException ex) {
        return ex.getMessage();
    }

    @ResponseBody
    @ExceptionHandler({BookNotFoundException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    String bookNotFoundHandler(BookNotFoundException ex) {
        return ex.getMessage();
    }
}
