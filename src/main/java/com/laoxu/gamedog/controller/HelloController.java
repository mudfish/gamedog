package com.laoxu.gamedog.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xusucheng
 * @create 2018-12-14
 **/
@RestController
@RequestMapping("/hello")
public class HelloController {
    @RequestMapping("/")
    public String sayHello(@RequestParam("name") String name){
        return "Hello "+name+"!";
    }
}
