package com.beliakaliaksei.library.service;

import com.beliakaliaksei.library.entity.Reader;
import com.beliakaliaksei.library.exception.ReaderHasBookException;
import com.beliakaliaksei.library.exception.ReaderNotFoundException;
import com.beliakaliaksei.library.exception.SuchEmailAlreadyExistsException;
import com.beliakaliaksei.library.exception.UserNotFoundException;
import org.springframework.data.domain.Page;

import java.util.List;

public interface IReaderService {
    Page<Reader> getAllReaders(int page, int pageSize);
    List<Reader> getReadersWithoutBooks();
    void addNewReader(Reader reader) throws SuchEmailAlreadyExistsException;
    void updateReader(Reader reader, long id) throws SuchEmailAlreadyExistsException, ReaderNotFoundException;
    Reader getById(long id) throws ReaderNotFoundException;
    void deleteReaders(List<Long> readerIds) throws ReaderNotFoundException, ReaderHasBookException;
}
