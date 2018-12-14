package com.laoxu.gamedog.job;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * 测试定时任务
 *
 * @author xusucheng
 * @create 2018-12-03
 **/
@Component
public class TestJob {
    /**
     * 每5秒钟执行一次
     */
    @Scheduled(cron = "0/5 * * * * ?")
    public void sayHello(){
        System.out.println("Hello World at "+System.currentTimeMillis());
    }
}
