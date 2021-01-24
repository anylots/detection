package com.frame.detection.common;

import com.google.common.util.concurrent.RateLimiter;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.concurrent.TimeUnit;


@Configuration
public class WebMvcConfiguration implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        /**
         * ImageDetectController，1秒钟生成20个令牌，也就是1秒中允许20个人访问
         */
        registry.addInterceptor(new RateLimiterInterceptor(RateLimiter.create(20, 1, TimeUnit.SECONDS)))
                .addPathPatterns("/detect", "/detectImage", "/detectWithCache", "/detectOutWithCache");
    }

}