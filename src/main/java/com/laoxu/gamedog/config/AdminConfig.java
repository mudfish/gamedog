package com.laoxu.gamedog.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 管理员账号配置
 *
 * @author xusucheng
 * @create 2018-10-26
 **/
@Component
@ConfigurationProperties(prefix = "admin")
public class AdminConfig {
    private String username;
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
