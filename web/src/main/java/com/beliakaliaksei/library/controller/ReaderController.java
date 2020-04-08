package com.beliakaliaksei.library.controller;

import com.beliakaliaksei.library.dto.ReaderDto;
import com.beliakaliaksei.library.entity.Reader;
import com.beliakaliaksei.library.repository.ReaderRepository;
import com.beliakaliaksei.library.service.IReaderService;
import com.beliakaliaksei.library.util.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/readers")
@CrossOrigin
public class ReaderController {
    private IReaderService readerService;

    @Autowired
    public ReaderController(IReaderService readerService) {
        this.readerService = readerService;
    }

    @GetMapping("/all")
    public List<Reader> getReaders() {
        return readerService.getAllReaders();
    }

    @PostMapping("/add")
    public void saveReader(@Valid @RequestBody ReaderDto readerDto) {
        readerService.addNewReader(Mapper.map(readerDto, Reader.class));
    }

    @PutMapping("/edit/{id}")
    public void editReader(@PathVariable("id") long id, @Valid @RequestBody ReaderDto readerDto) {
        readerService.updateReader(Mapper.map(readerDto, Reader.class), id);
    }
}
