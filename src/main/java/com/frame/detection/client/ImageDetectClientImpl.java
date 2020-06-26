package com.frame.detection.client;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

/**
 * @author anylots
 * @version $Id: HttpClientImpl.java, v 0.1 2020年06月26日 22:50 anylots Exp $
 */
@Component
public class ImageDetectClientImpl implements ImageDetectClient {

    @Override
    public String getImageInfo(String imageLink) {

        RestTemplate restTemplate = new RestTemplate();

        String url = "http://127.0.0.1:8081/detect/imageDetect";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
        map.add("imageLink", imageLink);

        HttpEntity<MultiValueMap<String, String>> request;
        request = new HttpEntity<>(map, headers);
        ResponseEntity<String> response = restTemplate.postForEntity(url, request, String.class);

        return response.getBody();
    }

}