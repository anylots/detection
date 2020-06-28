
package com.frame.detection.common;

/**
 * image detector
 *
 * @author anylots
 * @version $Id: ImageDetector.java, v 0.1 2020年06月26日 18:36 anylots Exp $
 */
public interface ImageDetector {

    /**
     * detect
     *
     * @param imageUrl image url
     * @return
     */
    String detect(String imageUrl);
}