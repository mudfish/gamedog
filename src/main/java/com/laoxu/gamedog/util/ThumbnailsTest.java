package com.laoxu.gamedog.util;

import net.coobird.thumbnailator.Thumbnails;

import java.io.IOException;

/**
 * 缩略图测试
 *
 * @author xusucheng
 * @create 2018-10-17
 **/
public class ThumbnailsTest {
    public static void main(String[] args) {
        String fileName = "GT-300-NZ-3A1_JC1-20-86.png";
        String thumbFileName=fileName.substring(0, fileName.lastIndexOf("."))+"-thumb"+fileName.substring(fileName.lastIndexOf("."));
        String path="D:/";
        try {
            Thumbnails.of(path+fileName).size(190,180).toFile(path+thumbFileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
