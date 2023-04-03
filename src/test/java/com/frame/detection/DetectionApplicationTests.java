package com.frame.detection;

import com.frame.detection.service.ImageConsultService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;

import java.util.HashMap;
import java.util.Map;

@SpringBootTest
class DetectionApplicationTests {


    @Autowired
    private ImageConsultService imageConsultService;

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Test
    void contextLoads() {

    }

    @Test
    public void testRedisObj() {
        // Map<String, Object> properties = new HashMap<>();
        // properties.put("123", "hello");
        // properties.put("abc", "success");

        // redisTemplate.opsForHash().putAll("hash", properties);

        // Map<Object, Object> ans = redisTemplate.opsForHash().entries("hash");
        // System.out.println("ans: " + ans);

    }

    @Test
    public void testImageDetectService() {
        // Map<String, Object> consultOut = new HashMap<>();
        // consultOut.put("testId", "hello");

        // redisTemplate.opsForHash().putAll("consultOut", consultOut);
        // try {
        //     String result = imageConsultService.detectInQueue("http://i0.hdslb.com/bfs/archive/b95b8f5f84f86eeae701577eab3b8bd2e1c39953.jpg");
        //     System.out.println("ans: " + result);
        // } catch (Exception e) {

        // }
    }


}
