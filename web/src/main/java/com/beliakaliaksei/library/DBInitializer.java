package com.beliakaliaksei.library;

import com.beliakaliaksei.library.entity.Photo;
import com.beliakaliaksei.library.entity.User;
import com.beliakaliaksei.library.entity.enumeration.Role;
import com.beliakaliaksei.library.exception.SuchEmailAlreadyExistsException;
import com.beliakaliaksei.library.repository.PhotoRepository;
import com.beliakaliaksei.library.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

@Component
@ConditionalOnProperty(name = "app.db-init", havingValue = "true")
public class DBInitializer implements CommandLineRunner {
    private PhotoRepository photoRepository;
    private IUserService userService;

    @Autowired
    public DBInitializer(PhotoRepository photoRepository, IUserService userService) {
        this.photoRepository = photoRepository;
        this.userService = userService;
    }

    @Override
    public void run(String... args) {
        Photo photo = new Photo((long) 1, "https://res.cloudinary.com/dsnsf4ukx/image/upload/v1586440687/Default_f7tcwx.jpg");
        photoRepository.save(photo);
        User user = new User((long)1, "alexbeljak99@gmail.com", "123456", Role.ADMIN);
        try {
            userService.addNewUser(user);
        } catch (SuchEmailAlreadyExistsException e) {
            System.out.println(e.getMessage());
        }
    }
}
