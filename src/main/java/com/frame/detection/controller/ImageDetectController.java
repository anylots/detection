/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package com.frame.detection.controller;

import com.frame.detection.service.ImageDetectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * controller of image detect
 *
 * @author anylots
 * @version $Id: ImageDetectController.java, v 0.1 2020年06月26日 18:56 anylots Exp $
 */
@Controller
@ResponseBody
public class ImageDetectController {

    /**
     * service of imageDetect
     */
    @Autowired
    private ImageDetectService imageDetectService;

    /**
     * detect
     *
     * @param imageUrl
     * @return
     */
    @RequestMapping(value = "/detect", method = RequestMethod.POST)
    public ModelAndView detect(String imageUrl) {
        return new ModelAndView("detect");
    }

    /**
     * detect out
     *
     * @param imageUrl
     * @return
     */
    @RequestMapping(value = "/detect", method = RequestMethod.POST)
    public ModelAndView detectOut(String imageUrl) {

        // step 1. detect image by imageUrl
        byte[] detectFrame = imageDetectService.detect(imageUrl);

        // step 2. assemble modelAndView
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("detectImage", detectFrame);

        // step 3. return detect result page
        return modelAndView;
    }
}