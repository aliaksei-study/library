package com.beliakaliaksei.library.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class AuthorNotFoundException extends Exception {
    public AuthorNotFoundException() {

    }

    public AuthorNotFoundException(String message) {
        super(message);
    }
}
