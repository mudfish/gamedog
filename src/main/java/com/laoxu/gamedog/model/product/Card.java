package com.laoxu.gamedog.model.product;

import com.laoxu.gamedog.framework.BaseModel;

import java.util.Date;

/**
 * 卡密
 *
 * @author xusucheng
 * @create 2018-11-14
 **/
public class Card extends BaseModel {
    private Long productId;
    private String cardNo;
    private String cardPassword;
    //开卡时间
    private Date openTime;
    //优先级
    private Integer priority;

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    public String getCardPassword() {
        return cardPassword;
    }

    public void setCardPassword(String cardPassword) {
        this.cardPassword = cardPassword;
    }

    public Date getOpenTime() {
        return openTime;
    }

    public void setOpenTime(Date openTime) {
        this.openTime = openTime;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }
}
