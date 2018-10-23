package com.laoxu.gamedog.model;

/**
 * 游戏账户
 *
 * @author xusucheng
 * @create 2018-10-17
 **/
public class Account {
    //账号
    private String account;
    //密码
    private String password;
    //金元宝
    private int goldCoin;
    //银元宝
    private int silverCoin;
    //权限
    private int privilege;
    //校验码
    private String checksum;

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getGoldCoin() {
        return goldCoin;
    }

    public void setGoldCoin(int goldCoin) {
        this.goldCoin = goldCoin;
    }

    public int getSilverCoin() {
        return silverCoin;
    }

    public void setSilverCoin(int silverCoin) {
        this.silverCoin = silverCoin;
    }

    public int getPrivilege() {
        return privilege;
    }

    public void setPrivilege(int privilege) {
        this.privilege = privilege;
    }

    public String getChecksum() {
        return checksum;
    }

    public void setChecksum(String checksum) {
        this.checksum = checksum;
    }
}
