package com.beliakaliaksei.library.service;

import com.beliakaliaksei.library.entity.Book;
import com.beliakaliaksei.library.entity.BookKeeper;
import com.beliakaliaksei.library.entity.Reader;
import com.beliakaliaksei.library.exception.ReaderNotFoundException;
import com.beliakaliaksei.library.repository.BookKeeperRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class BookKeeperServiceImpl implements IBookKeeperService {
    private BookKeeperRepository bookKeeperRepository;
    private IReaderService readerService;

    public BookKeeperServiceImpl(BookKeeperRepository bookKeeperRepository, IReaderService readerService) {
        this.bookKeeperRepository = bookKeeperRepository;
        this.readerService = readerService;
    }


    @Override
    public void giveOutTheBook(BookKeeper bookKeeper, Long readerId) throws ReaderNotFoundException {
        Reader reader = readerService.getById(readerId);
        bookKeeper.setReader(reader);
        bookKeeperRepository.save(bookKeeper);
    }

    @Override
    public void returnTheBook(Book book, Reader reader) {

    }
}
