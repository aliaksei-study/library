package com.beliakaliaksei.library.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ReaderHasBookException extends Exception {

    public ReaderHasBookException() {

    }

    public ReaderHasBookException(String message) {
        super(message);
    }
}
