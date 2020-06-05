package com.beliakaliaksei.library.service;

import com.beliakaliaksei.library.entity.Book;
import com.beliakaliaksei.library.entity.BookKeeper;
import com.beliakaliaksei.library.entity.Reader;
import com.beliakaliaksei.library.repository.BookKeeperRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class BookKeeperServiceImpl implements IBookKeeperService {
    private BookKeeperRepository bookKeeperRepository;

    public BookKeeperServiceImpl(BookKeeperRepository bookKeeperRepository) {
        this.bookKeeperRepository = bookKeeperRepository;
    }


    @Override
    public void giveOutTheBook(BookKeeper bookKeeper) {
        bookKeeperRepository.save(bookKeeper);
    }

    @Override
    public void returnTheBook(Book book, Reader reader) {

    }
}
