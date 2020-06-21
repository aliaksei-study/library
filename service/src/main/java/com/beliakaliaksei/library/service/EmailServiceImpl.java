package com.beliakaliaksei.library.service;

import com.beliakaliaksei.library.entity.Email;
import com.beliakaliaksei.library.exception.ReaderNotFoundException;
import com.beliakaliaksei.library.repository.EmailRepository;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class EmailServiceImpl implements IEmailService {
    private final EmailRepository emailRepository;
    private final IReaderService readerService;
    private final JavaMailSender mailSender;

    public EmailServiceImpl(EmailRepository emailRepository, IReaderService readerService, JavaMailSender mailSender) {
        this.emailRepository = emailRepository;
        this.readerService = readerService;
        this.mailSender = mailSender;
    }

    @Override
    public Email getRandomTemplate() {
        List<Email> emailTemplates = emailRepository.findAll();
        if(emailTemplates.size() > 0) {
            return emailTemplates.get((int) (Math.random() * emailTemplates.size()));
        }
        return new Email();
    }

    @Override
    public void sendEmailToReaders(List<Long> readerIds, Email email) throws ReaderNotFoundException {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom("jubabirdman236@gmail.com");
        simpleMailMessage.setSubject(email.getSubject());
        simpleMailMessage.setText(email.getText());
        for(long id: readerIds) {
            simpleMailMessage.setTo(readerService.getById(id).getUser().getEmail());
            mailSender.send(simpleMailMessage);
        }
    }

    @Override
    public void saveTemplate(Email emailTemplate) {
        emailRepository.save(emailTemplate);
    }
}
