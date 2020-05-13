package com.beliakaliaksei.library.service;

import com.beliakaliaksei.library.entity.Photo;
import com.beliakaliaksei.library.entity.Reader;
import com.beliakaliaksei.library.exception.ReaderNotFoundException;
import com.beliakaliaksei.library.exception.SuchEmailAlreadyExistsException;
import com.beliakaliaksei.library.repository.ReaderRepository;
import com.beliakaliaksei.library.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class ReaderServiceImpl implements IReaderService {
    private final ReaderRepository readerRepository;
    private final IPhotoService photoService;
    private final UserRepository userRepository;
    private PasswordEncoder passwordEncoder;

    @Autowired
    public ReaderServiceImpl(ReaderRepository readerRepository, IPhotoService photoService,
                             UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.readerRepository = readerRepository;
        this.photoService = photoService;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }


    @Override
    public Page<Reader> getAllReaders(int page) {
        final int sizeOfPage = 1;
        Pageable pageable = PageRequest.of(page, sizeOfPage);
        return readerRepository.findAll(pageable);
    }

    @Override
    public void addNewReader(Reader reader) throws SuchEmailAlreadyExistsException {
        setDefaultPhotoIfIsNotExists(reader);
        if (userRepository.loadUserByUsername(reader.getUser().getEmail()) == null) {
            reader.getUser().setPassword(passwordEncoder.encode((reader.getUser().getPassword())));
            readerRepository.save(reader);
        } else {
            throw new SuchEmailAlreadyExistsException("User with such email already exists");
        }
    }

    @Override
    public void updateReader(Reader reader, long id) {
        reader.setId(id);
        readerRepository.save(reader);
    }

    @Override
    public Reader getById(long id) throws ReaderNotFoundException {
        return readerRepository.findById(id).orElseThrow(ReaderNotFoundException::new);
    }

    public void setDefaultPhotoIfIsNotExists(Reader reader) {
        if (reader.getPhoto() == null) {
            Photo photo = photoService.findById(1);
            reader.setPhoto(photo);
        }
    }
}
