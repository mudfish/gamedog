package com.laoxu.gamedog.framework;

import java.util.Date;

/**
 * 基准模型
 *
 * @author xusucheng
 * @create 2018-11-06
 **/
public class BaseModel {
    //行ID
    private Long id;
    //创建人
    private String creater;
    //创建时间
    private Date createTime;
    //修改人
    private String updater;
    //修改时间
    private Date updateTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCreater() {
        return creater;
    }

    public void setCreater(String creater) {
        this.creater = creater;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getUpdater() {
        return updater;
    }

    public void setUpdater(String updater) {
        this.updater = updater;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
