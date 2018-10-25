package com.laoxu.gamedog.controller;

import com.laoxu.gamedog.framework.Result;
import com.laoxu.gamedog.framework.ResultUtil;
import com.laoxu.gamedog.model.Account;
import com.laoxu.gamedog.model.RegisterConfig;
import com.laoxu.gamedog.model.RegisterRecord;
import com.laoxu.gamedog.service.AccountService;
import com.laoxu.gamedog.service.RegisterConfigService;
import com.laoxu.gamedog.service.RegisterRecordService;
import com.laoxu.gamedog.util.IpUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 账号控制器
 *
 * @author xusucheng
 * @create 2018-10-23
 **/
@RestController
@RequestMapping(value = "/account")
public class AccountController {
    private static final Logger LOG = LoggerFactory.getLogger(AccountController.class);

    @Autowired
    private AccountService accountService;

    @Autowired
    private RegisterConfigService registerConfigService;

    @Autowired
    private RegisterRecordService registerRecordService;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Result<String> add(@RequestBody Account entity, HttpServletRequest request) {
        String ip = IpUtil.getIpAddr(request);
        //获取注册配置
        RegisterConfig registerConfig = registerConfigService.load();
        int registerMaxNum = registerConfig.getLimitNum();
        int registerLimitHour = registerConfig.getLimitHour();

        //判断是否超过注册限制
        Map<String, Object> param = new HashMap<>();
        param.put("ip", ip);
        param.put("limitHour", registerLimitHour);
        int registerCount = registerRecordService.getCountByIp(param);

        if (registerCount >= registerMaxNum) {
            return ResultUtil.fail(registerLimitHour + "小时内最多允许注册" + registerMaxNum + "个账号！");
        }

        if (accountService.load(entity.getAccount()) != null) {
            return ResultUtil.fail("账号已存在！");
        } else {
            //金元宝
            entity.setGoldCoin(registerConfig.getGoldCoin());
            //银元宝
            entity.setSilverCoin(registerConfig.getSilverCoin());
            accountService.add(entity);

            //插入注册记录
            RegisterRecord registerRecord = new RegisterRecord(System.currentTimeMillis(), ip, new Date());
            registerRecordService.add(registerRecord);
        }

        return ResultUtil.ok();
    }
}
