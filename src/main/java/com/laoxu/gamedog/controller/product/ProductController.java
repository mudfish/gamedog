package com.laoxu.gamedog.controller.product;

import com.laoxu.gamedog.framework.Result;
import com.laoxu.gamedog.framework.ResultUtil;
import com.laoxu.gamedog.model.product.ProductType;
import com.laoxu.gamedog.service.product.ProductTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.Date;
import java.util.List;

/**
 * 商品管理控制器
 *
 * @author xusucheng
 * @create 2018-11-06
 **/
@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductTypeService productTypeService;

    /**
     * 新增商品分类
     * @param productType
     * @return
     */
    @PostMapping("/addProductType")
    public Result<String> addProductType(@RequestBody ProductType productType, Principal principal){
        productType.setCreater(principal.getName());
        productType.setCreateTime(new Date());
        productType.setUpdater(principal.getName());
        productType.setUpdateTime(new Date());

        productTypeService.add(productType);

        return ResultUtil.ok();
    }

    /**
     * 获取商品分类列表
     * @return
     */
    @GetMapping("/listProductType")
    public Result<List<ProductType>> listProductType(){
        List<ProductType> productTypes = productTypeService.list();

        return ResultUtil.ok(productTypes);
    }

    @PostMapping("/removeProductType")
    public Result<String> removeProductType(@RequestParam("ids") List<Long> ids){
        productTypeService.remove(ids);

        return ResultUtil.ok();
    }

}
