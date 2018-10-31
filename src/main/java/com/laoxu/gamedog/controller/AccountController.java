package com.laoxu.gamedog.controller;

import com.laoxu.gamedog.framework.Result;
import com.laoxu.gamedog.framework.ResultUtil;
import com.laoxu.gamedog.model.Account;
import com.laoxu.gamedog.model.RegisterConfig;
import com.laoxu.gamedog.model.RegisterRecord;
import com.laoxu.gamedog.service.AccountService;
import com.laoxu.gamedog.service.RegisterConfigService;
import com.laoxu.gamedog.service.RegisterRecordService;
import com.laoxu.gamedog.util.AccountUtil;
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

    /**
     * 新增账号
     * @param entity
     * @param request
     * @return
     */
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

    /**
     * 修改密码
     * @param param
     * @return
     */
    @RequestMapping(value="/changePassword", method=RequestMethod.POST)
    public Result<String> changePassword(@RequestBody Map<String,String> param){
        //获取加密密码
        String account = param.get("account");
        String password = param.get("password");
        String passwordNew = param.get("passwordNew");

        param.put("password",AccountUtil.getEncPassword(account,password));
        //查询账号
        Account entity = accountService.loadByAccountPassword(param);

        if(entity==null){
            return ResultUtil.fail("账号或密码错误！");
        }

        entity.setPassword(passwordNew);

        accountService.modify(entity);

        return ResultUtil.ok();
    }

}
