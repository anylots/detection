package com.frame.detection.service;

/**
 * @author anylots
 * @version $Id: ImageConsultService.java, v 0.1 2020年09月12日 11:32 anylots Exp $
 */
public interface ImageConsultService {

    /**
     * detect in queue by url
     *
     * @param imageUrl image url
     */
    String detectInQueue(String imageUrl) throws Exception;
}