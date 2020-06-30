package com.frame.detection.client;

import org.springframework.util.MultiValueMap;

/**
 * image detect client
 *
 * @author anylots
 * @version $Id: HttpClient.java, v 0.1 2020年06月26日 22:42 anylots Exp $
 */
public interface ImageDetectClient {

    /**
     * get detect image post
     *
     * @param paramMap paramMap
     * @return
     */
    String getDetectImagePost(MultiValueMap<String, String> paramMap);

}