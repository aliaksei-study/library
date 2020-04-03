package com.beliakaliaksei.library.service;



import com.beliakaliaksei.library.entity.Photo;
import com.beliakaliaksei.library.repository.PhotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class PhotoServiceImpl implements IPhotoService {
    private final PhotoRepository photoRepository;

    @Autowired
    public PhotoServiceImpl(PhotoRepository photoRepository) {
        this.photoRepository = photoRepository;
    }

    @Override
    public void addNewPhoto(Photo photo) {

    }

    @Override
    public void deletePhoto(Photo photo) {

    }

    @Override
    public Photo getById(long id) {
        return null;
    }
}
