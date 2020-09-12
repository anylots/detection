
package com.frame.detection.service;

import org.springframework.web.multipart.MultipartFile;

/**
 * image detect service
 *
 * @author anylots
 * @version $Id: ImageDetectService.java, v 0.1 2020年06月26日 18:22 anylots Exp $
 */
public interface ImageDetectService {

    /**
     * detect by url
     *
     * @param imageUrl image url
     */
    String detectByUrl(String imageUrl);

    /**
     * detect by file
     *
     * @param imageFile imageFile
     */
    String detectByFile(MultipartFile imageFile);

}