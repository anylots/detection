
package com.frame.detection.common;

/**
 * image detector
 *
 * @author anylots
 * @version $Id: ImageDetector.java, v 0.1 2020年06月26日 18:36 anylots Exp $
 */
public interface ImageDetector {

    /**
     * get image info by url
     *
     * @param imageLink image link
     * @return
     */
    String getDetectImageByUrl(String imageLink);

    /**
     * get image info by code
     *
     * @param imageBase64Code imageBase64Code
     * @return
     */
    String getDetectImageByCode(String imageBase64Code);
}