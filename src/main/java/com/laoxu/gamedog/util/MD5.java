package com.laoxu.gamedog.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.MessageDigest;

/**
 * @author xusucheng
 * @create 2018-10-22
 *
 * MD5加密类
 **/
public class MD5 {
    private static final char[] HEX_DIGITS = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    public static String getMD5(byte[] bytes) {
        byte[] _bytes = getMD5Bytes(bytes);
        return byteArrayToHexString(_bytes);
    }

    public static String getMD5(String str) {
        return getMD5(str.getBytes());
    }

    protected static byte[] getMD5Bytes(byte[] bytes) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            return md.digest(bytes);
        } catch (Exception localException) {
        }
        return null;
    }

    protected static String getMD5(Object object) {
        if (object != null) {
            byte[] bytes = BytesHelper.objectToByte(object);
            return getMD5(bytes);
        }
        return null;
    }

    public static String getMD5(File file) {
        FileInputStream fis = null;
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            fis = new FileInputStream(file);
            byte[] buffer = new byte[2048];
            int length = -1;

            while ((length = fis.read(buffer)) != -1) {
                md.update(buffer, 0, length);
            }
            byte[] b = md.digest();
            return byteArrayToHexString(b);
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        } finally {
            try {
                if (fis != null)
                    fis.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    protected static String byteArrayToHexString(byte[] bytes) {
        char[] chars = new char[32];

        int k = 0;
        for (int i = 0; i < 16; i++) {
            byte b = bytes[i];
            chars[(k++)] = HEX_DIGITS[(b >>> 4 & 0xF)];
            chars[(k++)] = HEX_DIGITS[(b & 0xF)];
        }
        return new String(chars);
    }

    public static void main(String[] args) {
        System.out.println(MD5.getMD5("laoxu123" + MD5.getMD5("123").toUpperCase() + "20070201").toUpperCase());
    }
}
