
package com.frame.detection.service;

/**
 * image detect service
 *
 * @author anylots
 * @version $Id: ImageDetectService.java, v 0.1 2020年06月26日 18:22 anylots Exp $
 */
public interface ImageDetectService {

    /**
     * detect
     *
     * @param imageUrl image url
     */
    String detect(String imageUrl);
}