package com.laoxu.gamedog.service;

import com.laoxu.gamedog.framework.AbstractService;
import com.laoxu.gamedog.model.RegisterConfig;
import org.springframework.stereotype.Service;

/**
 * 账号服务
 *
 * @author xusucheng
 * @create 2018-10-23
 **/
@Service
public class RegisterConfigService extends AbstractService {

    /**
     * 查询
     * @param account
     * @return
     */
    public RegisterConfig load() {
        return selectOne("registerConfigMapper.load","");
    }


}
