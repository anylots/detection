
package com.frame.detection.common;

import java.awt.image.BufferedImage;

/**
 * buffered image service
 *
 * @author anylots
 * @version $Id: BufferedImageService.java, v 0.1 2020年06月26日 18:29 anylots Exp $
 */
public interface BufferedImageService {

    /**
     * get remote buffered image
     *
     * @param imageURL
     */
    BufferedImage getRemoteBufferedImage(String imageURL);


    /**
     * create detected frame
     *
     * @param bImage
     * @return
     */
    byte[] createDetectedFrame(BufferedImage bImage);

}