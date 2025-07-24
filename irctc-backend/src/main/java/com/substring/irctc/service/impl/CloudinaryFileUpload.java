package com.substring.irctc.service.impl;

import com.substring.irctc.entity.ImageMetaData;
import com.substring.irctc.service.FileUploadService;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public class CloudinaryFileUpload implements FileUploadService {

    @Override
    public ImageMetaData upload(MultipartFile file) throws IOException{
        //logic to upload file to cloudinary

        return null;
    }
}
