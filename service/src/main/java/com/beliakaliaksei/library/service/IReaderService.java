package com.beliakaliaksei.library.service;

import com.beliakaliaksei.library.entity.Reader;
import com.beliakaliaksei.library.exception.SuchEmailAlreadyExistsException;
import org.springframework.data.domain.Page;

import java.util.List;

public interface IReaderService {
    Page<Reader> getAllReaders(int page);
    void addNewReader(Reader reader) throws SuchEmailAlreadyExistsException;
    void updateReader(Reader reader, long id);
    Reader getById(long id);
}
