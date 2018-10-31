package com.laoxu.gamedog.service;

import com.laoxu.gamedog.framework.AbstractService;
import com.laoxu.gamedog.model.Account;
import com.laoxu.gamedog.util.AccountUtil;
import com.laoxu.gamedog.util.MD5;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Map;

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

    /**
     * 根据账号查询
     * @param account
     * @return
     */
    public Account load(String account) {
        return selectOne("accountMapper.load", account);
    }


    /**
     * 根据账号和密码查询（此处可与load方法合并）
     * @param param
     * @return
     */
    public Account loadByAccountPassword(Map<String,String> param) {
        return selectOne("accountMapper.loadByAccountPassword", param);
    }

}
