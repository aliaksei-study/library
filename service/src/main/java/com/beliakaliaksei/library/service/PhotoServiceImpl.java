package com.beliakaliaksei.library.service;



import com.beliakaliaksei.library.dto.PhotoDto;
import com.beliakaliaksei.library.dto.ReaderDto;
import com.beliakaliaksei.library.entity.Photo;
import com.beliakaliaksei.library.repository.PhotoRepository;
import com.beliakaliaksei.library.util.CloudinaryHelper;
import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.io.File;
import java.io.IOException;
import java.util.Map;

@Service
@Transactional
public class PhotoServiceImpl implements IPhotoService {
    private final PhotoRepository photoRepository;
    private Cloudinary cloudinary;

    @Autowired
    public PhotoServiceImpl(PhotoRepository photoRepository) {
        this.photoRepository = photoRepository;
        cloudinary = CloudinaryHelper.getCloudinary();
    }

    @Override
    public void addNewPhoto(PhotoDto photoDto) {
        Photo photo = new Photo();
        Map upload = null;
        try {
            upload = cloudinary.uploader().upload(photoDto.getFile(), ObjectUtils.emptyMap());
        } catch (IOException e) {
            e.printStackTrace();
        }
        if(upload != null) {
            photoDto.setUrlPhoto(upload.get("url").toString());
            photo.setUrlPhoto(upload.get("url").toString());
            photoRepository.save(photo);
        }
    }

    @Override
    public void deletePhoto(Photo photo) {
        photoRepository.delete(photo);
    }

    @Override
    public Photo findById(long id) {
        return photoRepository.findById(id);
    }

    @Override
    public void createByFileNewUrlOfPhoto(ReaderDto readerDto) {
        if(readerDto.getPhotoDto().getFile() != null) {
            File file = new File("E:\\"+readerDto.getPhotoDto().getFile().getName());
            readerDto.getPhotoDto().setFile(file);
            addNewPhoto(readerDto.getPhotoDto());
        }
    }
}
