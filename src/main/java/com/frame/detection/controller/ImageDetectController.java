
package com.frame.detection.controller;

import com.frame.detection.constants.ViewModelConstants;
import com.frame.detection.service.ImageDetectService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

/**
 * controller of image detect
 *
 * @author anylots
 * @version $Id: ImageDetectController.java, v 0.1 2020年06月26日 18:56 anylots Exp $
 */
@Controller
public class ImageDetectController {

    /**
     * logger of ImageDetectController
     */
    private Logger logger = LoggerFactory.getLogger(ImageDetectController.class);

    /**
     * service of imageDetect
     */
    @Autowired
    private ImageDetectService imageDetectService;

    /**
     * detect out
     *
     * @return
     */
    @RequestMapping(value = "/detect", method = RequestMethod.GET)
    public String detect() {

        return ViewModelConstants.DETECT;
    }

    /**
     * detect out
     *
     * @param imageLink
     * @return
     */
    @RequestMapping(value = "/detectImage", method = RequestMethod.POST)
    public ModelAndView detectOut(String imageLink, MultipartFile imageFile) {

        // step 1. detect image
        String detectOut = imageDetectService.detectByUrl(imageLink);

        // step 2. assemble modelAndView
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName(ViewModelConstants.DETECT_OUT);
        modelAndView.addObject(ViewModelConstants.DETECT_OUT_IMAGE, detectOut);

        // step 3. return detect result page
        return modelAndView;
    }

}