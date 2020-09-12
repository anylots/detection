package com.frame.detection.cache;

import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Configuration;

/**
 * @author anylots
 * @version $Id: RedisConfig.java, v 0.1 2020年09月12日 10:32 anylots Exp $
 */
@Configuration
@EnableCaching
public class RedisConfig extends CachingConfigurerSupport {
    //doNothing
}