package com.beliakaliaksei.library.repository;

import com.beliakaliaksei.library.entity.Photo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PhotoRepository extends CrudRepository<Photo, Long> {
    Photo findById(long id);
    Optional<Photo> findPhotoByUrlPhoto(String urlPhoto);
}
