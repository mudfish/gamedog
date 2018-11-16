package com.laoxu.gamedog.model.order;

import com.laoxu.gamedog.framework.BaseModel;

import java.util.Date;

/**
 * 订单
 *
 * @author xusucheng
 * @create 2018-11-16
 **/
public class Order extends BaseModel {
    private String orderNo;
    private Long productId;
    private String productName;
    private Integer qty;
    private Double amount;
    private Integer status;
    //支付渠道
    private String paySource;
    //付款交易号
    private String payNo;
    //联系方式
    private String contact;

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Integer getQty() {
        return qty;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getPaySource() {
        return paySource;
    }

    public void setPaySource(String paySource) {
        this.paySource = paySource;
    }

    public String getPayNo() {
        return payNo;
    }

    public void setPayNo(String payNo) {
        this.payNo = payNo;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }
}
