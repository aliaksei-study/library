package com.beliakaliaksei.library.service;

import com.beliakaliaksei.library.entity.Book;
import com.beliakaliaksei.library.entity.BookKeeper;
import com.beliakaliaksei.library.entity.Reader;
import com.beliakaliaksei.library.exception.ReaderNotFoundException;

public interface IBookKeeperService {
    void giveOutTheBook(BookKeeper bookKeeper, Long readerId) throws ReaderNotFoundException;
    void returnTheBook(Book book, Reader reader);
}
