package com.substring.irctc.dto;

import com.substring.irctc.entity.Train;
import com.substring.irctc.entity.TrainImage;
import com.substring.irctc.service.TrainImageService;
import org.springframework.core.io.Resource;

public record TrainImageDataWithResource(
        TrainImage trainImage,
        Resource resource
) {
}
