package com.laoxu.gamedog.util;

import com.laoxu.gamedog.model.Account;

import java.util.Date;

/**
 * 账号工具类型
 *
 * @author xusucheng
 * @create 2018-10-23
 **/
public class AccountUtil {
    public static Account getNewAccount(Account entity){
        //密码加密
        String encPassword = AccountUtil.getEncPassword(entity.getAccount(), entity.getPassword());
        entity.setPassword(encPassword);
        entity.setChecksum(AccountUtil.getCheckSum(entity.getAccount(), encPassword,entity.getGoldCoin(),entity.getSilverCoin(),0));
        entity.setUpdateTime(new Date());

        return entity;
    }

    //生成加密密码
    public static String getEncPassword(String account, String password) {
        return MD5.getMD5(account + MD5.getMD5(password).toUpperCase() + "20070201").toUpperCase();
    }

    //生成校验位
    public static String getCheckSum(String account, String encPassword, int goldCoin, int silverCoin, int privilege) {
        return MD5.getMD5(
                account + encPassword + String.format("%08X", new Object[]{Integer.valueOf(privilege)}) +
                        String.format("%08X", new Object[]{Long.valueOf(goldCoin)}) +
                        String.format("%08X", new Object[]{Long.valueOf(silverCoin)}) + "ABCDEF")
                .toUpperCase();
    }


}
