
package com.frame.detection.common;

import com.frame.detection.client.ImageDetectClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

/**
 * implement of ImageDetector
 *
 * @author anylots
 * @version $Id: ImageDetectorImpl.java, v 0.1 2020年06月26日 18:39 anylots Exp $
 */
@Component
public class ImageDetectorImpl implements ImageDetector {

    /**
     * image detect client
     */
    @Autowired
    private ImageDetectClient imageDetectClient;


    /**
     * get image info by url
     *
     * @param imageLink image link
     * @return
     */
    @Override
    public String getDetectImageByUrl(String imageLink) {

        MultiValueMap<String, String> paramMap = new LinkedMultiValueMap<>();
        paramMap.add("imageLink", imageLink);
        return imageDetectClient.getDetectImagePost(paramMap);
    }

    /**
     * get image info by code
     *
     * @param imageBase64Code imageBase64Code
     * @return
     */
    @Override
    public String getDetectImageByCode(String imageBase64Code) {
        MultiValueMap<String, String> paramMap = new LinkedMultiValueMap<>();
        paramMap.add("imageBase64Code", imageBase64Code);
        return imageDetectClient.getDetectImagePost(paramMap);
    }
}