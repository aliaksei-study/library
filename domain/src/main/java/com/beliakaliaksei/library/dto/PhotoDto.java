package com.beliakaliaksei.library.dto;

import com.beliakaliaksei.library.validator.Image;
import lombok.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

@Data
@NoArgsConstructor
public class PhotoDto {
    private Long id;
    @Image
    private File file;
    private String urlPhoto;
}
