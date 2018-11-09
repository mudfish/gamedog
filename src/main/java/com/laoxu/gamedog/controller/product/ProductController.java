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
     * 保存商品分类
     * @param productType
     * @return
     */
    @PostMapping("/saveProductType")
    public Result<String> saveProductType(@RequestBody ProductType productType, Principal principal){
        if(principal==null){
            return ResultUtil.fail("请登录后操作！");
        }

        if(productType.getId()==null){
            productType.setCreater(principal.getName());
            productType.setCreateTime(new Date());
        }

        productType.setUpdater(principal.getName());
        productType.setUpdateTime(new Date());

        productTypeService.save(productType);

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

    /**
     * 获取商品分类
     * @return
     */
    @GetMapping("/loadProductType")
    public Result<ProductType> loadProductType(@RequestParam("id") Long id){
        ProductType productType = productTypeService.load(id);

        return ResultUtil.ok(productType);
    }

    /**
     * 删除单条商品分类
     * @param id
     * @return
     */
    @PostMapping("/removeProductType")
    public Result<String> removeProductType(@RequestParam("id") Long id){
        productTypeService.remove(id);

        return ResultUtil.ok();
    }

    /**
     * 删除多条商品分类
     * @param ids
     * @return
     */
    @PostMapping("/removeProductTypes")
    public Result<String> removeProductType(@RequestParam("ids") Long[] ids){
        productTypeService.remove(ids);

        return ResultUtil.ok();
    }

}
