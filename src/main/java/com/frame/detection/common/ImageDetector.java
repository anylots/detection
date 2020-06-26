
package com.frame.detection.common;

import java.awt.image.BufferedImage;

/**
 * @author anylots
 * @version $Id: ImageDetector.java, v 0.1 2020年06月26日 18:36 anylots Exp $
 */
public interface ImageDetector {

    /**
     * detect
     *
     * @param imageURL
     * @return
     */
    String detect(String imageURL);
}