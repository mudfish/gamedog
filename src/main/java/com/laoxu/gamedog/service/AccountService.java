package com.laoxu.gamedog.service;

import com.laoxu.gamedog.framework.AbstractService;
import com.laoxu.gamedog.model.Account;
import com.laoxu.gamedog.util.AccountUtil;
import com.laoxu.gamedog.util.MD5;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * 账号服务
 *
 * @author xusucheng
 * @create 2018-10-23
 **/
@Service
public class AccountService extends AbstractService {
    /**
     * 保存
     *
     * @param entity
     */
    public void add(Account entity) {
        insert("accountMapper.insert", AccountUtil.getNewAccount(entity));
    }

    /**
     * 更新
     *
     * @param entity
     */
    public void modify(Account entity) {
        update("accountMapper.update", AccountUtil.getNewAccount(entity));
    }


    public Account load(String account) {
        return selectOne("accountMapper.load", account);
    }

}
