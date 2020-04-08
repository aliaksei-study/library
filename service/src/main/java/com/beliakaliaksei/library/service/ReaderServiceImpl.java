package com.beliakaliaksei.library.service;

import com.beliakaliaksei.library.entity.Reader;
import com.beliakaliaksei.library.repository.ReaderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ReaderServiceImpl implements IReaderService{
    private final ReaderRepository readerRepository;

    @Autowired
    public ReaderServiceImpl(ReaderRepository readerRepository) {
        this.readerRepository = readerRepository;
    }


    @Override
    public List<Reader> getAllReaders() {
        return readerRepository.findAll();
    }

    @Override
    public void addNewReader(Reader reader) {
        readerRepository.save(reader);
    }

    @Override
    public void updateReader(Reader reader, long id) {
        reader.setId(id);
        readerRepository.save(reader);
    }

    @Override
    public Reader getById(long id) {
        return readerRepository.findById(id).orElse(new Reader());
    }
}
