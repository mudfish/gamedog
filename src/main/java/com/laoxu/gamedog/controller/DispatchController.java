package com.laoxu.gamedog.controller;

import com.laoxu.gamedog.service.RegisterRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

/**
 * 调度控制器
 *
 * @author xusucheng
 * @create 2018-10-26
 **/
@Controller
public class DispatchController {
    @Autowired
    private RegisterRecordService registerRecordService;

    @RequestMapping("/login")
    public String login(){
        return "login";
    }

    @RequestMapping("/admin")
    public ModelAndView admin(){
        ModelAndView mv = new ModelAndView("admin");
        Map<String,Object> registerCountMap = registerRecordService.getCountByTime();
        mv.addObject("registerCountMap",registerCountMap);
        return mv;
    }

    /**
     * 账号列表
     * @return
     */
    @RequestMapping("/accountList")
    public String accountList(){
        return "accountList";
    }

    /**
     * 商品分类
     * @return
     */
    @RequestMapping("/product/productType")
    public String productType(){
        return "product/productType";
    }

    /**
     * 添加商品
     * @return
     */
    @RequestMapping("/product/addProduct")
    public String addProduct(){
        return "product/addProduct";
    }

    /**
     * 商品列表
     * @return
     */
    @RequestMapping("/product/productList")
    public String productList(){
        return "product/productList";
    }

    /**
     * 添加卡密
     * @return
     */
    @RequestMapping("/product/addCard")
    public String addCard(){
        return "product/addCard";
    }

    /**
     * 卡密列表
     * @return
     */
    @RequestMapping("/product/cardList")
    public String cardList(){
        return "product/cardList";
    }

    /**
     * 订单列表
     * @return
     */
    @RequestMapping("/trade/orderList")
    public String orderList(){
        return "trade/orderList";
    }


}
