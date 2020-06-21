package com.beliakaliaksei.library.service;

import com.beliakaliaksei.library.entity.Email;
import com.beliakaliaksei.library.exception.ReaderNotFoundException;

import java.util.List;

public interface IEmailService {
    Email getRandomTemplate();
    void sendEmailToReaders(List<Long> readerIds, Email email) throws ReaderNotFoundException;
    void saveTemplate(Email email);
}
