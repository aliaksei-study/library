package com.beliakaliaksei.library.controller;

import com.beliakaliaksei.library.entity.Reader;
import com.beliakaliaksei.library.repository.ReaderRepository;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ReaderController {
    private ReaderRepository readerRepository;

    public ReaderController(ReaderRepository readerRepository) {
        this.readerRepository = readerRepository;
    }

    @GetMapping("/readers")
    public List<Reader> getReaders() {
        return readerRepository.findAll();
    }
}
