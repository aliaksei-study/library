package com.beliakaliaksei.library.service;

import com.beliakaliaksei.library.exception.AuthorNotFoundException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import static org.mockito.ArgumentMatchers.any;

class AuthorServiceImplTest {
    @Mock
    private static AuthorServiceImpl authorService;

    @BeforeAll
    static void initializeVariables() {
        authorService = Mockito.mock(AuthorServiceImpl.class);
    }

    @Test
    void whenGetAuthorWithInvalidId_thenThrowAuthorNotFoundException() throws AuthorNotFoundException {
        Long invalidAuthorId = (long) -2;
        Mockito.when(authorService.getAuthorById(invalidAuthorId))
                .thenThrow(AuthorNotFoundException.class);
        Assertions.assertThrows(AuthorNotFoundException.class, () -> authorService.getAuthorById(invalidAuthorId));
    }

    @Test
    void whenSaveAuthor_thenExpectCallMethodSaveNewAuthor() {
        authorService.saveNewAuthor(any());
        Mockito.verify(authorService, Mockito.times(1)).saveNewAuthor(any());
    }
}