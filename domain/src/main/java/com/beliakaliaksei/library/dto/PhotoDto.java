package com.beliakaliaksei.library.dto;

import lombok.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

@Data
@NoArgsConstructor
public class PhotoDto {
    private Long id;
    private File file;
    private String urlPhoto;
}
