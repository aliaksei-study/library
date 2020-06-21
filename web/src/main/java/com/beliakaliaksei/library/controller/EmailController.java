package com.beliakaliaksei.library.controller;

import com.beliakaliaksei.library.dto.EmailDto;
import com.beliakaliaksei.library.entity.Email;
import com.beliakaliaksei.library.exception.ReaderNotFoundException;
import com.beliakaliaksei.library.service.IEmailService;
import com.beliakaliaksei.library.util.Mapper;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/mail")
public class EmailController {
    private final IEmailService emailService;

    public EmailController(IEmailService emailService) {
        this.emailService = emailService;
    }

    @GetMapping("/templates/random-template")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Email getEmailTemplate() {
        return emailService.getRandomTemplate();
    }

    @PostMapping("/templates")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void saveTemplate(@Valid @RequestBody EmailDto emailDto) {
        emailService.saveTemplate(Mapper.map(emailDto, Email.class));
    }

    @PostMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void sendEmail(@PathVariable("id") List<Long> readerIds, @Valid @RequestBody EmailDto emailDto)
            throws ReaderNotFoundException {
        emailService.sendEmailToReaders(readerIds, Mapper.map(emailDto, Email.class));
    }
}
