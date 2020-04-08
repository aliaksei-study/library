package com.beliakaliaksei.library.service;

import com.beliakaliaksei.library.entity.Reader;

import java.util.List;

public interface IReaderService {
    List<Reader> getAllReaders();
    void addNewReader(Reader reader);
    void updateReader(Reader reader, long id);
    Reader getById(long id);
}
