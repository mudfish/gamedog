package com.laoxu.gamedog.controller.order;

import com.laoxu.gamedog.framework.Result;
import com.laoxu.gamedog.framework.ResultUtil;
import com.laoxu.gamedog.framework.pagination.BtPagingResult;
import com.laoxu.gamedog.model.order.Order;
import com.laoxu.gamedog.service.order.OrderService;
import com.laoxu.gamedog.util.CommonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
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

    /**
     * 获取订单列表（分页）
     *
     * @return
     */
    @GetMapping("/list")
    @ResponseBody
    public BtPagingResult<Map<String, Object>> list(@RequestParam("limit") Integer limit,
                                                    @RequestParam("offset") Integer offset,
                                                    @RequestParam("s_productId") Long productId,
                                                    @RequestParam("s_orderNo") String orderNo) {
        List<Map<String, Object>> orders = orderService.list(limit,offset,productId,orderNo);

        BtPagingResult<Map<String, Object>> result = new BtPagingResult<>(orders);

        return result;
    }

    @GetMapping("/search")
    @ResponseBody
    public Result<List<Map<String, Object>>> list(@RequestParam("ka") String search) {
        if(StringUtils.isEmpty(search)){
            return ResultUtil.fail("查询参数为空！");
        }

        List<Map<String, Object>> orders = orderService.search(search);

        return ResultUtil.ok(orders);
    }

    @RequestMapping("/chaxun")
    public ModelAndView chaxun(@RequestParam("orderNo") String orderNo){
        ModelAndView mv = new ModelAndView("trade/chaxun");
        List<Map<String, Object>> orders = orderService.search(orderNo);
        mv.addObject("orders", orders);
        mv.addObject("orderNo",orderNo);
        return mv;
    }
}
