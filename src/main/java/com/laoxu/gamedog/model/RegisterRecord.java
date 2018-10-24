package com.laoxu.gamedog.model;

import java.util.Date;

/**
 * 注册记录
 *
 * @author xusucheng
 * @create 2018-10-24
 **/
public class RegisterRecord {
    private Long id;
    private String ip;
    private Date registerTime;

    public RegisterRecord(Long id, String ip, Date registerTime) {
        this.id = id;
        this.ip = ip;
        this.registerTime = registerTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Date getRegisterTime() {
        return registerTime;
    }

    public void setRegisterTime(Date registerTime) {
        this.registerTime = registerTime;
    }
}
