package com.substring.irctc.service;

import com.substring.irctc.entity.ImageMetaData;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface FileUploadService {
    ImageMetaData upload(MultipartFile file) throws IOException;
}
