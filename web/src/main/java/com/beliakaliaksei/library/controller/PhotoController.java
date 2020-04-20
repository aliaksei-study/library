package com.beliakaliaksei.library.controller;

import com.beliakaliaksei.library.dto.PhotoDto;
import com.beliakaliaksei.library.entity.Photo;
import com.beliakaliaksei.library.service.IPhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/photos")
public class PhotoController {
    private IPhotoService photoService;

    @Autowired
    public PhotoController(IPhotoService photoService) {
        this.photoService = photoService;
    }

    @PostMapping
    public void addNewPhoto(@RequestBody PhotoDto photoDto) {
    }
}
