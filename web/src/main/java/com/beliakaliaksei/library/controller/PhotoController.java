package com.beliakaliaksei.library.controller;

import com.beliakaliaksei.library.dto.PhotoDto;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/photos")
@CrossOrigin
public class PhotoController {

    @PostMapping("/add")
    public void savePhoto(@RequestBody PhotoDto photoDto) {

    }
}
