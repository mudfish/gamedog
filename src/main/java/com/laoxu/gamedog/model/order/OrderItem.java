package com.laoxu.gamedog.model.order;

import com.laoxu.gamedog.framework.BaseModel;

/**
 * 订单明细
 *
 * @author xusucheng
 * @create 2018-11-16
 **/
public class OrderItem extends BaseModel {
    private Long orderId;
    private String orderNo;
    private Long cardId;
    private String cardNo;
    private String cardPassword;

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public Long getCardId() {
        return cardId;
    }

    public void setCardId(Long cardId) {
        this.cardId = cardId;
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
}
