package com.beliakaliaksei.library.controller;

import com.beliakaliaksei.library.dto.ReaderDto;
import com.beliakaliaksei.library.entity.Reader;
import com.beliakaliaksei.library.exception.SuchEmailAlreadyExistsException;
import com.beliakaliaksei.library.service.IPhotoService;
import com.beliakaliaksei.library.service.IReaderService;
import com.beliakaliaksei.library.util.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/readers")
public class ReaderController {
    private IReaderService readerService;
    private IPhotoService photoService;

    @Autowired
    public ReaderController(IReaderService readerService, IPhotoService photoService) {
        this.readerService = readerService;
        this.photoService = photoService;
    }

    @GetMapping
    public Page<Reader> getReaders(@RequestParam (defaultValue = "0") int page) {
        return readerService.getAllReaders(page);
    }

    @GetMapping("/{id}")
    public Reader getReaderById(@PathVariable("id") Long id) {
        return readerService.getById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void saveNewReader(@Valid @RequestBody ReaderDto readerDto) throws SuchEmailAlreadyExistsException {
        if(readerDto.getPhotoDto() != null) {
            photoService.createByFileNewUrlOfPhoto(readerDto.getPhotoDto());
        }
        readerService.addNewReader(Mapper.map(readerDto, Reader.class));
    }

    @PutMapping("/{id}")
    public void editReader(@PathVariable("id") Long id, @Valid @RequestBody ReaderDto readerDto) {
        readerService.updateReader(Mapper.map(readerDto, Reader.class), id);
    }
}
