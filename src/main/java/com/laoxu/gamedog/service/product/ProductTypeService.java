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
     * 保存
     * @param entity
     */
    public void save(ProductType entity){
        if(entity.getId() == null){
            insert("productTypeMapper.insert", entity);
        }else {
            insert("productTypeMapper.update", entity);
        }
    }

    /**
     * 删除单条
     * @param idAry
     */
    public void remove(Long id){
        Map<String,Object> param = new HashMap<>();
        delete("productTypeMapper.deleteById", id);
    }

    /**
     * 删除多条
     * @param idAry
     */
    public void remove(Long[] idAry){
        Map<String,Object> param = new HashMap<>();
        param.put("idAry",idAry);
        delete("productTypeMapper.deleteByIds", param);
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
