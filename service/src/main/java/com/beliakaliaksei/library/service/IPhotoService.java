package com.beliakaliaksei.library.service;

import com.beliakaliaksei.library.dto.PhotoDto;
import com.beliakaliaksei.library.dto.ReaderDto;
import com.beliakaliaksei.library.entity.Photo;

import java.io.File;
import java.util.Optional;

public interface IPhotoService {
    void addNewPhoto(Photo photo);
    void deletePhoto(Photo photo);
    Photo findById(long id);
    void createByFileNewUrlOfPhoto(PhotoDto photo);
    Optional<Photo> findPhotoByUrlPhoto(String urlPhoto);
    String encodeLocallyUploadedImage(Long imageId);
}
