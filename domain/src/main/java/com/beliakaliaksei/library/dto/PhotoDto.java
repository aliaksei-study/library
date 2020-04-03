package com.beliakaliaksei.library.dto;

import lombok.*;
import org.springframework.web.multipart.MultipartFile;

@Data
@NoArgsConstructor
public class PhotoDto {
    private Long id;
    private MultipartFile file;
}
