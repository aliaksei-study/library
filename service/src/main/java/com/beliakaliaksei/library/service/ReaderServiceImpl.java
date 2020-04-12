package com.beliakaliaksei.library.service;

import com.beliakaliaksei.library.entity.Photo;
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
    private final IPhotoService photoService;

    @Autowired
    public ReaderServiceImpl(ReaderRepository readerRepository, IPhotoService photoService) {
        this.readerRepository = readerRepository;
        this.photoService = photoService;
    }


    @Override
    public List<Reader> getAllReaders() {
        return readerRepository.findAll();
    }

    @Override
    public void addNewReader(Reader reader) {
        setDefaultPhotoIfIsNotExists(reader);
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

    public void setDefaultPhotoIfIsNotExists(Reader reader) {
        if(reader.getPhoto() == null) {
            Photo photo = photoService.findById(1);
            System.out.println(photo);
            reader.setPhoto(photo);
        }
    }
}
