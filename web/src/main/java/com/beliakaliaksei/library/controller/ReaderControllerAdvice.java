package com.beliakaliaksei.library.controller;

import com.beliakaliaksei.library.exception.ReaderNotFoundException;
import com.beliakaliaksei.library.exception.SuchEmailAlreadyExistsException;
import com.beliakaliaksei.library.exception.UserNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ReaderControllerAdvice {

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
}
