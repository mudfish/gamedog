package com.laoxu.gamedog.service.product;

import com.laoxu.gamedog.framework.AbstractService;
import com.laoxu.gamedog.model.product.Card;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 卡密服务
 *
 * @author xusucheng
 * @create 2018-11-14
 **/
@Service
public class CardService extends AbstractService {

    public void save(Card entity){
        entity.setUpdater("admin");
        entity.setUpdateTime(new Date());
        if(entity.getId() == null){
            entity.setCreater("admin");
            entity.setCreateTime(new Date());
            insert("cardMapper.insert", entity);
        }else {
            insert("cardMapper.update", entity);
        }
    }

    public void remove(Long id){
        Map<String,Object> param = new HashMap<>();
        delete("cardMapper.deleteById", id);
    }


    public void remove(Long[] idAry){
        Map<String,Object> param = new HashMap<>();
        param.put("idAry",idAry);
        delete("cardMapper.deleteByIds", param);
    }

    public List<Map<String,Object>> list(){
        return selectList("cardMapper.selectAll");
    }

    public Card load(Long id){
        return selectOne("cardMapper.load", id);
    }
}
