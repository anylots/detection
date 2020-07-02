
package com.frame.detection.service.impl;

import com.frame.detection.common.ImageDetector;
import com.frame.detection.service.ImageDetectService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import sun.misc.BASE64Encoder;

import java.io.IOException;

/**
 * implement of ImageDetectService
 *
 * @author anylots
 * @version $Id: ImageDetectServiceImpl.java, v 0.1 2020年06月26日 18:24 anylots Exp $
 */
@Service
public class ImageDetectServiceImpl implements ImageDetectService {

    /**
     * logger of ImageDetectServiceImpl
     */
    private Logger logger = LoggerFactory.getLogger(ImageDetectServiceImpl.class);

    /**
     * image detector
     */
    @Autowired
    private ImageDetector imageDetector;

    /**
     * detect by url
     *
     * @param imageUrl image url
     */
    @Override
    public String detectByUrl(String imageUrl) {
        //detect image
        String detectResult = imageDetector.getDetectImageByUrl(imageUrl);
        return detectResult;
    }

    /**
     * detect by file
     *
     * @param imageFile imageFile
     */
    @Override
    public String detectByFile(MultipartFile imageFile) {

        try {
            BASE64Encoder base64Encoder = new BASE64Encoder();
            String base64EncoderImg = base64Encoder.encode(imageFile.getBytes());
            return imageDetector.getDetectImageByCode(base64EncoderImg);

        } catch (IOException e) {
            logger.error("imageFile convert failed");
        }
        return null;
    }
}