package com.beliakaliaksei.library.controller;

import com.beliakaliaksei.library.exception.SuchEmailAlreadyExistsException;
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
}
