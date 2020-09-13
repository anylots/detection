package com.frame.detection.service.impl;

import com.alibaba.fastjson.JSON;
import com.frame.detection.constants.ServiceConstants;
import com.frame.detection.service.ImageConsultService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * implement of ImageConsultService
 *
 * @author anylots
 * @version $Id: ImageConsultServiceImpl.java, v 0.1 2020年09月12日 11:33 anylots Exp $
 */
@Service
public class ImageConsultServiceImpl implements ImageConsultService {

    /**
     * logger of ImageDetectServiceImpl
     */
    private Logger logger = LoggerFactory.getLogger(ImageDetectServiceImpl.class);

    /**
     * redis template,cache
     */
    @Autowired
    private StringRedisTemplate redisTemplate;

    private static final String IMAGE_QUEUE = "imageQueue";

    private static final String CONSULT_OUT = "consultOut";

    private static final String IMAGE_KEY = "imageKey";
    private static final String IMAGE_URL = "imageUrl";

    private static final Set<Long> TIME_INTERVALS = new HashSet<Long>() {
        {
            this.add(200l);
            this.add(400l);
            this.add(800l);
        }
    };


    /**
     * detect in queue by url
     *
     * @param imageUrl image url
     */
    @Override
    public String detectInQueue(String imageUrl) throws Exception {

        //step 1. Is the queue overrun
        if (redisTemplate.opsForList().size(IMAGE_QUEUE) > ServiceConstants.THREAD_STACK_SIZE) {
            logger.error("thread stack size is out of limit");
            throw new Exception("System busy,Please try again later");
        }

        //step 2. Put imageUrl in queue
        Map<String, Object> imageInfo = new HashMap<>();
        String imageKey = UUID.randomUUID().toString();
        imageInfo.put(IMAGE_KEY, imageKey);
        imageInfo.put(IMAGE_URL, imageUrl);
        redisTemplate.opsForList().leftPush(IMAGE_QUEUE, JSON.toJSONString(imageInfo));

        //step 3. Get the result
        for (Long interval : TIME_INTERVALS) {
            try {
                Thread.currentThread().sleep(interval.longValue());
                Object consultResult = redisTemplate.opsForHash().get(imageKey, CONSULT_OUT);
                if (consultResult != null) {
                    //delete result in cache
                    redisTemplate.delete(imageKey);
                    return (String) consultResult;
                }
            } catch (InterruptedException e) {
                logger.error("detect service thread error");
            }
        }
        return null;
    }
}