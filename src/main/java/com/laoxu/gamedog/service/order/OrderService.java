package com.laoxu.gamedog.service.order;

import com.laoxu.gamedog.framework.AbstractService;
import com.laoxu.gamedog.model.order.Order;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 订单服务
 *
 * @author xusucheng
 * @create 2018-11-19
 **/
@Service
public class OrderService extends AbstractService {
    /**
     * 保存
     * @param entity
     */
    public void save(Order entity){
        entity.setUpdater("admin");
        entity.setUpdateTime(new Date());
        if(entity.getId() == null){
            entity.setCreater("admin");
            entity.setCreateTime(new Date());
            insert("orderMapper.insert", entity);
        }else {
            insert("orderMapper.update", entity);
        }
    }

    /**
     * 删除单条
     * @param id
     */
    public void remove(Long id){
        Map<String,Object> param = new HashMap<>();
        delete("orderMapper.deleteById", id);
    }

    /**
     * 删除多条
     * @param idAry
     */
    public void remove(Long[] idAry){
        Map<String,Object> param = new HashMap<>();
        param.put("idAry",idAry);
        delete("orderMapper.deleteByIds", param);
    }

    /**
     * 查询列表
     * @return
     */
    public List<Map<String,Object>> list(){
        return selectList("orderMapper.selectAll");
    }


    /**
     * 查询列表
     * @return
     */
    public List<Map<String,Object>> list(Long OrderTypeId){
        return selectList("orderMapper.selectByOrderTypeId",OrderTypeId);
    }

    public List<Map<String,Object>> list(Integer limit, Integer offset, Long productId, String orderNo){
        Map<String,Object> param = new HashMap<>();
        param.put("limit", limit);
        param.put("offset",offset);
        param.put("productId",productId);
        param.put("orderNo", orderNo);

        return selectList("orderMapper.selectAll", param);
    }

    public List<Map<String, Object>> list(Map<String,Object> param){
        return selectList("orderMapper.selectList",param);
    }

    public List<Map<String, Object>> search(String search){
        return selectList("orderMapper.selectByParam",search);
    }

    /**
     * 单查询
     * @return
     */
    public Order load(Long id){
        return selectOne("orderMapper.load", id);
    }
}
