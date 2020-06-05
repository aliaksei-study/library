package com.beliakaliaksei.library.service;

import com.beliakaliaksei.library.entity.Book;
import com.beliakaliaksei.library.entity.BookKeeper;
import com.beliakaliaksei.library.entity.Reader;

public interface IBookKeeperService {
    void giveOutTheBook(BookKeeper bookKeeper);
    void returnTheBook(Book book, Reader reader);
}
