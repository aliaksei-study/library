package com.beliakaliaksei.library.service;

import com.beliakaliaksei.library.entity.BookKeeper;
import com.beliakaliaksei.library.exception.BookNotFoundException;
import com.beliakaliaksei.library.repository.BookKeeperRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class BookKeeperServiceImpl implements IBookKeeperService {
    private final BookKeeperRepository bookKeeperRepository;

    public BookKeeperServiceImpl(BookKeeperRepository bookKeeperRepository) {
        this.bookKeeperRepository = bookKeeperRepository;
    }

    @Override
    public void removeBookKeeper(BookKeeper bookKeeper) {
        bookKeeperRepository.delete(bookKeeper);
    }
}
