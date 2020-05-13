package com.beliakaliaksei.library.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ReaderNotFoundException extends Exception {
    public ReaderNotFoundException() {

    }

    public ReaderNotFoundException(String message) {
        super(message);
    }
}
