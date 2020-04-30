package com.beliakaliaksei.library.service;

import com.beliakaliaksei.library.dto.PhotoDto;
import com.beliakaliaksei.library.dto.ReaderDto;
import com.beliakaliaksei.library.entity.Photo;

import java.io.File;

public interface IPhotoService {
    void addNewPhoto(PhotoDto photoDto);
    void deletePhoto(Photo photo);
    Photo findById(long id);
    void createByFileNewUrlOfPhoto(PhotoDto photo);
}
