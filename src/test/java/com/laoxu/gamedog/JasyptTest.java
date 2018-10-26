package com.laoxu.gamedog;

import com.laoxu.gamedog.model.RegisterConfig;
import com.laoxu.gamedog.service.RegisterConfigService;
import org.jasypt.encryption.StringEncryptor;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 * 加密测试类
 *
 * @author xusucheng
 * @create 2018-10-23
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
@WebAppConfiguration
public class JasyptTest {
    @Autowired
    StringEncryptor encryptor;

    @Autowired
    RegisterConfigService registerConfigService;

    @Test
    public void getPass(){
        String url = encryptor.encrypt("jdbc:mysql://119.188.247.170/dl_adb_all?characterEncoding=utf-8&useSSL=false&serverTimezone=UTC&zeroDateTimeBehavior=convertToNull&transformedBitIsBoolean=true");
        String name = encryptor.encrypt("123");
        String password = encryptor.encrypt("123");
        System.out.println(url);
        System.out.println(name);
        System.out.println(password);
        Assert.assertTrue(password.length() > 0);
        Assert.assertTrue(name.length() > 0);

    }


}
