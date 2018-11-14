package com.laoxu.gamedog.model.product;

import com.laoxu.gamedog.framework.BaseModel;

/**
 * 商品分类
 *
 * @author xusucheng
 * @create 2018-11-06
 *
 **/
public class ProductType extends BaseModel {
    // 名称
    private String name;
    // 编码
    private String code;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
