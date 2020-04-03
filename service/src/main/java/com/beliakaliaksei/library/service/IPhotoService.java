package com.beliakaliaksei.library.service;

import com.beliakaliaksei.library.entity.Photo;

public interface IPhotoService {
    void addNewPhoto(Photo photo);
    void deletePhoto(Photo photo);
    Photo getById(long id);
}
