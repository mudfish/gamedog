package com.laoxu.gamedog.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 上传参数配置
 *
 * @author xusucheng
 * @create 2018-10-26
 **/
@Component
@ConfigurationProperties(prefix = "file.upload")
public class UploadConfig {
    private String path;

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
