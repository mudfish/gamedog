package com.laoxu.gamedog.controller.product;

import com.laoxu.gamedog.framework.Result;
import com.laoxu.gamedog.framework.ResultUtil;
import com.laoxu.gamedog.model.product.Product;
import com.laoxu.gamedog.service.product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 商品管理-商品-控制器
 *
 * @author xusucheng
 * @create 2018-11-06
 **/
@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    /**
     * 保存商品
     * @param product
     * @return
     */
    @PostMapping("/save")
    public Result<String> save(@RequestBody Product product, Principal principal){
        if(principal==null){
            return ResultUtil.fail("请登录后操作！");
        }

        if(product.getId()==null){
            product.setCreater(principal.getName());
            product.setCreateTime(new Date());
        }

        product.setUpdater(principal.getName());
        product.setUpdateTime(new Date());

        productService.save(product);

        return ResultUtil.ok();
    }


    /**
     * 获取商品列表
     * @return
     */
    @GetMapping("/list")
    public List<Map<String,Object>> list(){
        List<Map<String,Object>> products = productService.list();

        return products;
    }



    /**
     * 获取商品列表（根据商品分类ID）
     * @return
     */
    @GetMapping("/listByProductTypeId")
    public List<Map<String,Object>> listByProductTypeId(@RequestParam("productTypeId") Long productTypeId){
        List<Map<String,Object>> products = productService.list(productTypeId);

        return products;
    }



    /**
     * 获取商品
     * @return
     */
    @GetMapping("/load")
    public Result<Product> load(@RequestParam("id") Long id){
        Product product = productService.load(id);

        return ResultUtil.ok(product);
    }

    /**
     * 删除单条商品
     * @param id
     * @return
     */
    @PostMapping("/remove")
    public Result<String> removeProductType(@RequestParam("id") Long id){
        productService.remove(id);

        return ResultUtil.ok();
    }

    /**
     * 删除多条商品
     * @param ids
     * @return
     */
    @PostMapping("/removes")
    public Result<String> removes(@RequestParam("ids") Long[] ids){
        productService.remove(ids);

        return ResultUtil.ok();
    }

}
