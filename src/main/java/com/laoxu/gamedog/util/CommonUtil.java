package com.laoxu.gamedog.util;

import java.util.Date;
import java.util.UUID;

public class CommonUtil {
    public static String getUUID(){
       return UUID.randomUUID().toString().replace("-", "").toUpperCase();
    }

    public static String getOrderNo(String prefix, String salt){
        return prefix+String.valueOf(new Date().getTime())+salt;
    }
}
