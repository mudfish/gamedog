package com.laoxu.gamedog;

import com.laoxu.gamedog.service.RegisterConfigService;
import org.jasypt.encryption.StringEncryptor;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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
public class PropertyTest {
    @Value("${admin.username}")
    private String username;
    @Value("${admin.password}")
    private String password;

    @Test
    public void getProperty(){
        System.out.println(username);
        System.out.println(password);
    }


}
