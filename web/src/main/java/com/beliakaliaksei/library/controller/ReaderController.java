package com.beliakaliaksei.library.controller;

import com.beliakaliaksei.library.dto.ReaderDto;
import com.beliakaliaksei.library.entity.Reader;
import com.beliakaliaksei.library.exception.ReaderHasBookException;
import com.beliakaliaksei.library.exception.ReaderNotFoundException;
import com.beliakaliaksei.library.exception.SuchEmailAlreadyExistsException;
import com.beliakaliaksei.library.service.IPhotoService;
import com.beliakaliaksei.library.service.IReaderService;
import com.beliakaliaksei.library.util.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

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
    public Page<Reader> getReaders(@RequestParam (defaultValue = "0") int page,
                                   @RequestParam (defaultValue = "5") int pageSize) {
        return readerService.getAllReaders(page, pageSize);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Reader getReaderById(@PathVariable("id") Long id) throws ReaderNotFoundException {
        return readerService.getById(id);
    }

    @GetMapping("/without-book")
    @ResponseStatus(HttpStatus.OK)
    public List<Reader> getReadersWithoutBook() {
        return readerService.getReadersWithoutBooks();
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
    @ResponseStatus(HttpStatus.OK)
    public void editReader(@PathVariable("id") Long id, @Valid @RequestBody ReaderDto readerDto)
            throws SuchEmailAlreadyExistsException, ReaderNotFoundException {
        if(readerDto.getPhotoDto() != null) {
            photoService.createByFileNewUrlOfPhoto(readerDto.getPhotoDto());
        }
        readerService.updateReader(Mapper.map(readerDto, Reader.class), id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteReaders(@PathVariable("id") List<Long> readerIds) throws ReaderNotFoundException, ReaderHasBookException {
        readerService.deleteReaders(readerIds);
    }
}
