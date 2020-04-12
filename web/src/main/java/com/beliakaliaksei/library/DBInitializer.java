package com.beliakaliaksei.library;

import com.beliakaliaksei.library.entity.Photo;
import com.beliakaliaksei.library.repository.PhotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

@Component
@ConditionalOnProperty(name = "app.db-init", havingValue = "true")
public class DBInitializer implements CommandLineRunner {
    private PhotoRepository photoRepository;

    @Autowired
    public DBInitializer(PhotoRepository photoRepository) {
        this.photoRepository = photoRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Photo photo = new Photo((long) 1, "https://res.cloudinary.com/dsnsf4ukx/image/upload/v1586440687/Default_f7tcwx.jpg");
        photoRepository.save(photo);
    }
}
