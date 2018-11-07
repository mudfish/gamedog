package com.laoxu.gamedog.service.product;

import com.laoxu.gamedog.framework.AbstractService;
import com.laoxu.gamedog.model.product.ProductType;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 商品服务
 *
 * @author xusucheng
 * @create 2018-11-07
 **/
@Service
public class ProductTypeService extends AbstractService {
    /**
     * 新增
     * @param entity
     */
    public void add(ProductType entity){
        insert("productTypeMapper.insert", entity);
    }

    /**
     * 删除
     * @param idAry
     */
    public void remove(List<Long> idAry){
        Map<String,Object> param = new HashMap<>();
        param.put("idAry",idAry);
        delete("productTypeMapper.delete", param);
    }

    /**
     * 修改
     * @param entity
     */
    public void modify(ProductType entity){
        update("productTypeMapper.update", entity);
    }

    /**
     * 查询列表
     * @return
     */
    public List<ProductType> list(){
        return selectList("productTypeMapper.selectAll");
    }

    /**
     * 单查询
     * @return
     */
    public ProductType load(Long id){
        return selectOne("productTypeMapper.load", id);
    }
}
