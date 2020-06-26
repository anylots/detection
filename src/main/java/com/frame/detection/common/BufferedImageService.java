/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package com.frame.detection.common;

import java.awt.image.BufferedImage;

/**
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
     * image to bytes
     *
     * @param bImage
     * @return
     */
    byte[] imageToBytes(BufferedImage bImage);
}