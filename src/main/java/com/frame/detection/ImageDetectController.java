
package com.frame.detection;

import com.frame.detection.service.ImageDetectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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

        return "detect";
    }

    /**
     * detect out
     *
     * @param imageLink
     * @return
     */
    @RequestMapping(value = "/detectImage", method = RequestMethod.POST)
    public ModelAndView detectOut(String imageLink) {

        // step 1. detect image by imageUrl
        String detectFrame = imageDetectService.detect(imageLink);

        // step 2. assemble modelAndView
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("detectOut");
        modelAndView.addObject("img", detectFrame);

        // step 3. return detect result page
        return modelAndView;
    }

}