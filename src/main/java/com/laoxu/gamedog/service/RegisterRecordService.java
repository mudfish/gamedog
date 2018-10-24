package com.laoxu.gamedog.service;

import com.laoxu.gamedog.framework.AbstractService;
import com.laoxu.gamedog.model.RegisterRecord;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * 注册记录服务
 *
 * @author xusucheng
 * @create 2018-10-23
 **/
@Service
public class RegisterRecordService extends AbstractService {


    /**
     * 保存
     *
     * @param entity
     */
    public void add(RegisterRecord entity) {
        insert("accountMapper.insert", entity);
    }

    /**
     * 统计
     *
     * @param account
     * @return
     */
    public int getCountByIp(Map<String, Object> param) {
        return selectOne("registerRecordMapper.selectCountByIp", param);
    }


}
