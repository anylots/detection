
package com.frame.detection.common;

/**
 * @author anylots
 * @version $Id: ImageDetectorImpl.java, v 0.1 2020年06月26日 18:39 anylots Exp $
 */
public class ImageDetectorImpl implements ImageDetector {

    /**
     * detect
     *
     * @param imageURL
     * @return
     */
    @Override
    public String detect(String imageURL) {
        return "0,0,0,0,0.7,1";
    }
}