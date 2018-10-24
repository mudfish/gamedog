package com.laoxu.gamedog.model;

/**
 * 注册配置
 *
 * @author xusucheng
 * @create 2018-10-24
 **/
public class RegisterConfig {
    //金元宝
    private Integer goldCoin;
    //银元宝
    private Integer silverCoin;
    //注册间隔
    private Integer limitHour;
    //注册数
    private Integer limitNum;

    public Integer getGoldCoin() {
        return goldCoin;
    }

    public void setGoldCoin(Integer goldCoin) {
        this.goldCoin = goldCoin;
    }

    public Integer getSilverCoin() {
        return silverCoin;
    }

    public void setSilverCoin(Integer silverCoin) {
        this.silverCoin = silverCoin;
    }

    public Integer getLimitHour() {
        return limitHour;
    }

    public void setLimitHour(Integer limitHour) {
        this.limitHour = limitHour;
    }

    public Integer getLimitNum() {
        return limitNum;
    }

    public void setLimitNum(Integer limitNum) {
        this.limitNum = limitNum;
    }
}
