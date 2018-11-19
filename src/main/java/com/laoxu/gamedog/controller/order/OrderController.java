package com.laoxu.gamedog.controller.order;

import com.laoxu.gamedog.framework.Result;
import com.laoxu.gamedog.framework.ResultUtil;
import com.laoxu.gamedog.model.order.Order;
import com.laoxu.gamedog.service.order.OrderService;
import com.laoxu.gamedog.util.CommonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;


@Controller
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @ResponseBody
    @RequestMapping("/add")
    public Result<Map<String,Object>> add(@RequestBody Order order){
        //生成订单号
        String orderNo = CommonUtil.getOrderNo("SA",order.getContact());
        order.setOrderNo(orderNo);

        Map<String,Object> result = new HashMap<>();
        result.put("ddh",orderNo);

        orderService.save(order);
        return ResultUtil.ok(result);
    }
}
