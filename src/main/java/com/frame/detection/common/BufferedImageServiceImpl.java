
package com.frame.detection.common;

import org.springframework.stereotype.Component;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * @author anylots
 * @version $Id: BufferedImageServiceImpl.java, v 0.1 2020年06月26日 18:30 anylots Exp $
 */
@Component
public class BufferedImageServiceImpl implements BufferedImageService {

    /**
     * get remote buffered image
     *
     * @param imageURL
     */
    @Override
    public BufferedImage getRemoteBufferedImage(String imageURL) {

        InputStream is = null;
        BufferedImage bufferedImage = null;
        try {
            URL url = new URL(imageURL);
            is = url.openStream();
            bufferedImage = ImageIO.read(is);
        } catch (MalformedURLException e) {
            e.printStackTrace();
            System.out.println("imageURL: " + imageURL + ",无效!");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("imageURL: " + imageURL + ",读取失败!");
        } finally {
            try {
                if (is != null) {
                    is.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("imageURL: " + imageURL + ",流关闭异常!");
            }
        }
        return bufferedImage;

    }

    /**
     * create detected frame
     *
     * @param bImage
     * @return
     */
    @Override
    public byte[] createDetectedFrame(BufferedImage bImage) {
        //process detect frame
        //TODO
        return imageToBytes(bImage);
    }


    /**
     * image to bytes
     *
     * @param bImage
     * @return byte[]
     */
    private byte[] imageToBytes(BufferedImage bImage) {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        try {
            ImageIO.write(bImage, "png", out);
        } catch (IOException e) {
            //log.error(e.getMessage());
        }
        return out.toByteArray();
    }
}