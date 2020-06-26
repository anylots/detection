
package com.frame.detection.service.impl;

import com.frame.detection.common.BufferedImageService;
import com.frame.detection.common.ImageDetector;
import com.frame.detection.service.ImageDetectService;
import org.springframework.beans.factory.annotation.Autowired;

import java.awt.image.BufferedImage;
import java.util.Base64;

/**
 * @author anylots
 * @version $Id: ImageDetectServiceImpl.java, v 0.1 2020年06月26日 18:24 anylots Exp $
 */
public class ImageDetectServiceImpl implements ImageDetectService {

    @Autowired
    private BufferedImageService bufferedImageService;

    @Autowired
    private ImageDetector imageDetector;

    /**
     * detect
     *
     * @param imageUrl
     */
    @Override
    public byte[] detect(String imageUrl) {

        // step 1. receive image
        BufferedImage bufferedImage = bufferedImageService.getRemoteBufferedImage(imageUrl);

        //step 2. detect image
        String detectResult = imageDetector.detect(imageUrl);

        //step 3. convert image_array to byte_array
        byte[] imageBytes = bufferedImageService.imageToBytes(bufferedImage);

        //step 4. return image_info
        return Base64.getEncoder().encode(imageBytes);

    }
}