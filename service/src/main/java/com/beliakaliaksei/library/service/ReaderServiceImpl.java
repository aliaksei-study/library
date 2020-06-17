package com.beliakaliaksei.library.service;

import com.beliakaliaksei.library.entity.Photo;
import com.beliakaliaksei.library.entity.Reader;
import com.beliakaliaksei.library.exception.ReaderHasBookException;
import com.beliakaliaksei.library.exception.ReaderNotFoundException;
import com.beliakaliaksei.library.exception.SuchEmailAlreadyExistsException;
import com.beliakaliaksei.library.repository.ReaderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ReaderServiceImpl implements IReaderService {
    private final ReaderRepository readerRepository;
    private final IPhotoService photoService;
    private final IUserService userService;

    @Autowired
    public ReaderServiceImpl(ReaderRepository readerRepository, IPhotoService photoService, IUserService userService) {
        this.readerRepository = readerRepository;
        this.photoService = photoService;
        this.userService = userService;
    }


    @Override
    public Page<Reader> getAllReaders(int page, int pageSize) {
        Pageable pageable = PageRequest.of(page, pageSize);
        return readerRepository.findAll(pageable);
    }

    @Override
    public List<Reader> getReadersWithoutBooks() {
        return readerRepository.findReaderByBookNull();
    }

    @Override
    public void addNewReader(Reader reader) throws SuchEmailAlreadyExistsException {
        Optional<Photo> readerPhoto;
        setDefaultPhotoIfIsNotExists(reader);
        userService.addNewUser(reader.getUser());
        readerPhoto = photoService.findPhotoByUrlPhoto(reader.getPhoto().getUrlPhoto());
        readerPhoto.ifPresent(reader::setPhoto);
        readerRepository.save(reader);
    }

    @Override
    public void updateReader(Reader updatedReader, long id) throws SuchEmailAlreadyExistsException,
            ReaderNotFoundException {
        long userId;
        Reader savedReader = readerRepository.findById(id).orElseThrow(ReaderNotFoundException::new);
        userId = savedReader.getUser().getId();
        if (userService.isUserWithSuchEmailAlreadyExistsExcludedCurrentUser(updatedReader.getUser(), userId)) {
            throw new SuchEmailAlreadyExistsException();
        }
        updatedReader.getUser().setId(userId);
        if (!savedReader.getUser().getPassword().equals(updatedReader.getUser().getPassword())) {
            userService.encryptUserPassword(updatedReader.getUser());
        }
        if (updatedReader.getPhoto() != null) {
            Photo savedPhoto = photoService.findPhotoByUrlPhoto(updatedReader.getPhoto().getUrlPhoto())
                    .orElseGet(updatedReader::getPhoto);
            updatedReader.setPhoto(savedPhoto);
        } else {
            updatedReader.setPhoto(savedReader.getPhoto());
        }
        readerRepository.save(updatedReader);
    }

    @Override
    public Reader getById(long id) throws ReaderNotFoundException {
        return readerRepository.findById(id).orElseThrow(ReaderNotFoundException::new);
    }

    @Override
    public void deleteReaders(List<Long> readerIds) throws ReaderNotFoundException, ReaderHasBookException {
        Reader reader;
        isReadersReadingBooks(readerIds);
        for (long id : readerIds) {
            reader = readerRepository.findById(id).orElseThrow(ReaderNotFoundException::new);
            if((reader.getPhoto().getId() != 1) && (isPhotoHasOneReaderUsage(reader.getPhoto()))) {
                photoService.deletePhoto(reader.getPhoto());
            }
            readerRepository.delete(reader);
        }
    }

    public void setDefaultPhotoIfIsNotExists(Reader reader) {
        if (reader.getPhoto() == null) {
            Photo photo = photoService.findById(1);
            reader.setPhoto(photo);
        }
    }

    public boolean isPhotoHasOneReaderUsage(Photo photo) {
        return readerRepository.findReadersByPhoto(photo).size() == 1;
    }

    public boolean isReadersReadingBooks(List<Long> readerIds) throws ReaderNotFoundException, ReaderHasBookException {
        Reader reader;
        for(long id: readerIds) {
            reader = readerRepository.findById(id).orElseThrow(ReaderNotFoundException::new);
            if(reader.getBook() != null) {
                throw new ReaderHasBookException("Reader with id " + reader.getId() + " reading this book");
            }
        }
        return false;
    }
}
