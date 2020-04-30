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
import java.nio.file.Files;
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
        String localPathOfFile = "";
        try {
            upload = uploadViaCloudinary(photoDto.getFile());
        } catch (RuntimeException | IOException e) {
            e.printStackTrace();
            localPathOfFile = uploadLocally(photoDto.getFile());
        }
        if(upload != null) {
            photoDto.setUrlPhoto(upload.get("url").toString());
            photo.setUrlPhoto(upload.get("url").toString());
            //photoRepository.save(photo);
        } else {
            photoDto.setUrlPhoto(localPathOfFile);
            photo.setUrlPhoto(localPathOfFile);
            //photoRepository.save(photo);
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
    public void createByFileNewUrlOfPhoto(PhotoDto photoDto) {
        if (photoDto.getFile() != null) {
            File file = new File("E:\\" + photoDto.getFile().getName());
            photoDto.setFile(file);
            addNewPhoto(photoDto);
        }
    }

    public Map uploadViaCloudinary(File photo) throws IOException, RuntimeException {
        return cloudinary.uploader().upload(photo, ObjectUtils.emptyMap());
    }

    public String uploadLocally(File photo) {
        File file = new File("C:\\Users\\Admin\\IdeaProjects\\library\\web\\src\\main\\resources\\images" + photo.getName());
        try {
            byte[] photoBytes = Files.readAllBytes(photo.toPath());
            Files.write(file.toPath(), photoBytes);
        } catch(IOException e) {
            e.printStackTrace();
        }
        return file.getPath();
    }
}
