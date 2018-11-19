package com.laoxu.gamedog.service.product;

import com.laoxu.gamedog.framework.AbstractService;
import com.laoxu.gamedog.model.product.Product;
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
public class ProductService extends AbstractService {
    /**
     * 保存
     * @param entity
     */
    public void save(Product entity){
        if(entity.getId() == null){
            insert("productMapper.insert", entity);
        }else {
            insert("productMapper.update", entity);
        }
    }

    /**
     * 删除单条
     * @param id
     */
    public void remove(Long id){
        Map<String,Object> param = new HashMap<>();
        delete("productMapper.deleteById", id);
    }

    /**
     * 删除多条
     * @param idAry
     */
    public void remove(Long[] idAry){
        Map<String,Object> param = new HashMap<>();
        param.put("idAry",idAry);
        delete("productMapper.deleteByIds", param);
    }

    /**
     * 查询列表
     * @return
     */
    public List<Map<String,Object>> list(){
        return selectList("productMapper.selectAll");
    }


    /**
     * 查询列表
     * @return
     */
    public List<Map<String,Object>> list(Long productTypeId){
        return selectList("productMapper.selectByProductTypeId",productTypeId);
    }


    /**
     * 单查询
     * @return
     */
    public Product load(Long id){
        return selectOne("productMapper.load", id);
    }
}
