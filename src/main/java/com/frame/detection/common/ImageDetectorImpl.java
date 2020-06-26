
package com.frame.detection.common;

import com.frame.detection.client.ImageDetectClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author anylots
 * @version $Id: ImageDetectorImpl.java, v 0.1 2020年06月26日 18:39 anylots Exp $
 */
@Component
public class ImageDetectorImpl implements ImageDetector {

    @Autowired
    private ImageDetectClient imageDetectClient;

    /**
     * detect
     *
     * @param imageURL
     * @return
     */
    @Override
    public String detect(String imageURL) {
        return imageDetectClient.getImageInfo(imageURL);
    }
}