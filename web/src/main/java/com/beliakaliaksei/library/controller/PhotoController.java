package com.beliakaliaksei.library.controller;

import com.beliakaliaksei.library.dto.PhotoDto;
import com.beliakaliaksei.library.entity.Photo;
import com.beliakaliaksei.library.service.IPhotoService;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.FilenameUtils;
import org.hibernate.cache.spi.FilterKey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.sql.rowset.serial.SerialBlob;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/photos")
public class PhotoController {
    private IPhotoService photoService;

    @Autowired
    public PhotoController(IPhotoService photoService) {
        this.photoService = photoService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<List<String>> getImage(@PathVariable ("id") Long id) {
        return new ResponseEntity<>(List.of(photoService.encodeLocallyUploadedImage(id)), HttpStatus.OK);
    }
}
