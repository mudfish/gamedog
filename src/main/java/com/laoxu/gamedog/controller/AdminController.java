package com.laoxu.gamedog.controller;

import com.laoxu.gamedog.service.RegisterRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

/**
 * 调度控制器
 *
 * @author xusucheng
 * @create 2018-10-26
 **/
@Controller
public class AdminController {
    @Autowired
    private RegisterRecordService registerRecordService;

    @RequestMapping("/login")
    public String login(){
        return "login";
    }

    @RequestMapping("/admin")
    public ModelAndView admin(){
        ModelAndView mv = new ModelAndView("admin");
        Map<String,Object> registerCountMap = registerRecordService.getCountByTime();
        mv.addObject("registerCountMap",registerCountMap);
        return mv;
    }

    @RequestMapping("/accountList")
    public String accountList(){
        return "accountList";
    }
}
