package com.laoxu.gamedog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 调度控制器
 *
 * @author xusucheng
 * @create 2018-10-26
 **/
@Controller
public class DispatcherController {
    @RequestMapping("/login")
    public String login(){
        return "login";
    }

    @RequestMapping("/admin")
    public String admin(){
        return "admin2";
    }
}
