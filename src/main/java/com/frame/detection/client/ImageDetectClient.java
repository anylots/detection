package com.frame.detection.client;

/**
 * image detect client
 *
 * @author anylots
 * @version $Id: HttpClient.java, v 0.1 2020年06月26日 22:42 anylots Exp $
 */
public interface ImageDetectClient {

    /**
     * get image info
     *
     * @param imageLink image link
     * @return
     */
    String getImageInfo(String imageLink);
}