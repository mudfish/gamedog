package com.laoxu.gamedog.controller;

import com.laoxu.gamedog.framework.Result;
import com.laoxu.gamedog.framework.ResultUtil;
import com.laoxu.gamedog.model.Account;
import com.laoxu.gamedog.service.AccountService;
import com.laoxu.gamedog.util.IpUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

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

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Result<String> add(@RequestBody Account entity,HttpServletRequest request) {
        //获取Ip
        System.out.println(IpUtil.getIpAddr(request));

        if (accountService.load(entity.getAccount()) != null) {
            return ResultUtil.fail("账号已存在！");
        } else {
            accountService.add(entity);
        }

        return ResultUtil.ok();
    }
}
