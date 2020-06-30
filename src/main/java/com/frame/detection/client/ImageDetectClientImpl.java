package com.frame.detection.client;

import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

/**
 * implement of imageDetectClient
 *
 * @author anylots
 * @version $Id: HttpClientImpl.java, v 0.1 2020年06月26日 22:50 anylots Exp $
 */
@Component
public class ImageDetectClientImpl implements ImageDetectClient {

    /**
     * get detect image post
     *
     * @param paramMap paramMap
     * @return
     */
    @Override
    public String getDetectImagePost(MultiValueMap<String, String> paramMap) {

        // step 1. request
        String url = "http://127.0.0.1:8081/detect/imageDetect";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        HttpEntity<MultiValueMap<String, String>> request;
        request = new HttpEntity<>(paramMap, headers);

        //step 2. post http call
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.postForEntity(url, request, String.class);

        Assert.isTrue(HttpStatus.OK == response.getStatusCode(), "http call is failed");
        return response.getBody();
    }
}