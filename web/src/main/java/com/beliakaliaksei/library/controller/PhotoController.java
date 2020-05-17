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

    @PostMapping
    public void addNewPhoto(@RequestBody PhotoDto photoDto) {
    }

    @GetMapping("/{id}")
    public ResponseEntity<List<String>> getImage(@PathVariable ("id") Long id) {
        String result = null;
        if(id == 1) {
            result = photoService.findById(1).getUrlPhoto();
        } else {
            File file = new File(photoService.findById(id).getUrlPhoto());
            String encodeBase64 = null;
            String extension = FilenameUtils.getExtension(file.getName());
            try {
                FileInputStream fileInputStream = new FileInputStream(file);
                byte[] bytes = new byte[(int) file.length()];
                fileInputStream.read(bytes);
                encodeBase64 = Base64.encodeBase64String(bytes);
                result = "data:image/" + extension + ";base64," + encodeBase64;
                fileInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return new ResponseEntity<List<String>>(List.of(result), HttpStatus.OK);
    }
}
