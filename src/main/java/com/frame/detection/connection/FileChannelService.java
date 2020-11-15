package com.frame.detection.connection;

import org.thymeleaf.expression.Lists;

import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @author anylots
 * @version $Id: FileChannelService.java, v 0.1 2020年09月30日 21:19 anylots Exp $
 */
public class FileChannelService {

    public static void fileChannelApply() {
        try {
            RandomAccessFile aFile = new RandomAccessFile("F:\\server\\test\\text1.txt", "rw");
            FileChannel inChannel = aFile.getChannel();

            ByteBuffer buf = ByteBuffer.allocate(48);

            int bytesRead = inChannel.read(buf);
            while (bytesRead != -1) {

                System.out.println("Read " + bytesRead);
                buf.flip();

                while (buf.hasRemaining()) {
                    System.out.print((char) buf.get());
                }

                buf.clear();
                bytesRead = inChannel.read(buf);
            }
            aFile.close();

        } catch (Exception e) {
            System.out.println("fileChannel apply error" + e.getStackTrace());
        }
    }

    public static void main(String[] args) {
        fileChannelApply();
        List<Integer> numList=new ArrayList<Integer>(){{
            add(1);
        }

        };
        numList.add(1);
        numList.add(2);
        numList.add(20);
        numList.add(4);
        numList.add(6);
        numList.add(8);

            numList.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if(o1>o2){
                    return 1;
                }
                return -1;
            }
        });

        System.out.println(numList.subList(0,4));


        String originSting = "abACab";
        StringBuilder lowerString = new StringBuilder();
        StringBuilder uperString = new StringBuilder();
        for (int i = 0; i < originSting.length(); i++) {
            char s=originSting.charAt(i);
            if (String.valueOf(s).toLowerCase().equals(String.valueOf(s))) {
                lowerString.append(s);
            } else {
                uperString.append(s);
            }

        }
        System.out.println(lowerString.toString() + uperString.toString());
    }


}