package com.beliakaliaksei.library.service;



import com.beliakaliaksei.library.dto.PhotoDto;
import com.beliakaliaksei.library.dto.ReaderDto;
import com.beliakaliaksei.library.entity.Photo;
import com.beliakaliaksei.library.repository.PhotoRepository;
import com.beliakaliaksei.library.util.CloudinaryHelper;
import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Map;
import java.util.Optional;

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
    public void addNewPhoto(Photo photo) {
        photoRepository.save(photo);
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
            Map upload = null;
            String localPathOfFile;
            try {
                upload = uploadViaCloudinary(photoDto.getFile());
            } catch (RuntimeException | IOException e) {
                e.printStackTrace();
            }
            if(upload != null) {
                photoDto.setUrlPhoto(upload.get("url").toString());
            } else {
                localPathOfFile = uploadLocally(photoDto.getFile());
                photoDto.setUrlPhoto(localPathOfFile);
            }
        }
    }

    @Override
    public Optional<Photo> findPhotoByUrlPhoto(String urlPhoto) {
        return photoRepository.findPhotoByUrlPhoto(urlPhoto);
    }

    @Override
    public String encodeLocallyUploadedImage(Long imageId) {
        String result = null;
        if(imageId == 1) {
            result = findById(1).getUrlPhoto();
        } else {
            File file = new File(findById(imageId).getUrlPhoto());
            String encodeBase64;
            String extension = FilenameUtils.getExtension(file.getName());
            try {
                FileInputStream fileInputStream = new FileInputStream(file);
                byte[] bytes = new byte[(int) file.length()];
                fileInputStream.read(bytes);
                encodeBase64 = Base64.encodeBase64String(bytes);
                result = "data:image/" + extension + ";base64," + encodeBase64;
                fileInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    public Map uploadViaCloudinary(File photo) throws IOException, RuntimeException {
        return cloudinary.uploader().upload(photo, ObjectUtils.emptyMap());
    }

    public String uploadLocally(File photo) {
        File file = new File("C:\\Users\\Admin\\IdeaProjects\\library\\service\\src\\main\\resources\\images\\" + photo.getName());
        try {
            byte[] photoBytes = Files.readAllBytes(photo.toPath());
            Files.write(file.toPath(), photoBytes);
        } catch(IOException e) {
            e.printStackTrace();
        }
        return file.getPath();
    }
}
