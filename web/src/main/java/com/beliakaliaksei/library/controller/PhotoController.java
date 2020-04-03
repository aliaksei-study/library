package com.beliakaliaksei.library.controller;

import com.beliakaliaksei.library.dto.PhotoDto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/photos")
public class PhotoController {

    @PostMapping("/add")
    public void savePhoto(@RequestBody PhotoDto photoDto) {

    }
}
