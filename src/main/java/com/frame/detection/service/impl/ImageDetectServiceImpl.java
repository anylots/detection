
package com.frame.detection.service.impl;

import com.frame.detection.common.BufferedImageService;
import com.frame.detection.common.ImageDetector;
import com.frame.detection.service.ImageDetectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * implement of ImageDetectService
 *
 * @author anylots
 * @version $Id: ImageDetectServiceImpl.java, v 0.1 2020年06月26日 18:24 anylots Exp $
 */
@Service
public class ImageDetectServiceImpl implements ImageDetectService {

    /**
     * image detector
     */
    @Autowired
    private ImageDetector imageDetector;

    /**
     * detect
     *
     * @param imageUrl
     */
    @Override
    public String detect(String imageUrl) {

        //detect image
        String detectResult = imageDetector.detect(imageUrl);
        return detectResult;

    }
}